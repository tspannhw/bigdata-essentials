package com.needforcode.solr;

import com.needforcode.model.Person;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;

import java.io.IOException;

/**
 * SolrJ Simple example.
 */
public class SolrDemo {

    private static Logger log = Logger.getLogger(SolrDemo.class);

    private static final String DEFAULT_SOLRCONFIG_XML = "solrconfig.xml";
    private static final String DEFAULT_SCHEMA_XML = "schema.xml";

    private static String solrURL = "";
    private static String coreName = "";
    private static String configFileName = "";
    private static Person person;

    public static void main(String[] args) throws Exception {

        if (args.length !=3) {
            throw new IllegalArgumentException("Incorrect arguments");
        } else {
            solrURL = args[0];
            coreName = args[1];
            configFileName = args[2];
            }

        SolrServer solrServer = createSolrServer(solrURL);

        if(!solrCoreExists(coreName, solrServer)) {

            String instanceDir = System.getProperty("karaf.home") + "/data/solr/" + coreName;
            String configFile = StringUtils.defaultIfBlank(configFileName, DEFAULT_SOLRCONFIG_XML);

            try {
                CoreAdminRequest.createCore(coreName, instanceDir, solrServer, configFile,
                    DEFAULT_SCHEMA_XML);
            } catch (SolrServerException e) {
                log.error("SolrServerException creating " + coreName + " core", e);
            } catch (IOException e) {
                log.error("IOException creating " + coreName + " core", e);
            }
            person = populatePerson();
            solrServer.addBean(person);
            solrServer.commit();
        } else {

        }

        }

    private static Person populatePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("John");
        person.setCompany("Google");
        return person;
    }


    private static SolrServer createSolrServer(String solrURL) throws Exception {

        try {
            HttpSolrServer solrServer = new HttpSolrServer(solrURL);
            solrServer.setMaxRetries(1);
            solrServer.setConnectionTimeout(5000);
            solrServer.setSoTimeout(1000);
            solrServer.setDefaultMaxConnectionsPerHost(100);
            solrServer.setMaxTotalConnections(100);
            solrServer.setFollowRedirects(false);
            solrServer.setAllowCompression(true);
            return solrServer;
        } catch (Exception e) {
            throw new Exception("Exception while creating solrServer" + e.getMessage());
        }
    }

    private static boolean solrCoreExists(String coreName, SolrServer solrServer) {
        try {
            CoreAdminResponse response = CoreAdminRequest.getStatus(coreName, solrServer);
            return response.getCoreStatus(coreName).get("instanceDir") != null;
        } catch (SolrServerException e) {
            log.info("SolrServerException" + e.getMessage());
            return false;
        } catch (IOException e) {
            log.info("IOException " + e.getMessage());
            return false;
        }
    }
}
