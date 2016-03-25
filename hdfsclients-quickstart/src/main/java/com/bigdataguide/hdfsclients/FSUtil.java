package com.bigdataguide.hdfsclients;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

/**
 *  Create Hadoop configuration object.
 */
public class FSUtil {

    private static Configuration conf;

    public static FileSystem getDFS() throws Exception {
        if (conf == null) {
            conf = new Configuration();
        }
        try {
            return FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
