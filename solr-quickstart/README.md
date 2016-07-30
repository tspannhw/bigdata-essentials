## Apache Solr

### Introduction

- Information Retrival
  - Information retrieval is a field concerned with the structure, analysis, organization, storage, searching, and retrieval of information

- Apache Solr is full text search server with Lucene at the backend.
  - Lucene is and engine. It doesn't stand on its own.
  - Lucene is high-performance, text search engine library written in Java.
  - Solr exposes Lucene's Java API as REST like API's which can be called over HTTP from any language.

### Features

- Lucene Features
  - Fast, high performance, scalable search library.
  - Open source.
  - Indexing and Searching.
  - Inverted Index of documents.
  - Results can be get using HTTP Get.
  - Results by default as XML. But also json, php, ruby, python etc.

- Lucene Model
  - Documents Model
  - Index -> Documents -> Fields -> attributes


- Solr Features
  - Full Text Search
  - Distributed Search
  - Replication (when High query load)
  - Sharding (when index is huge)
  - Faceted Search (similar to GroupBY)
  - Caching
  - near real-time indexing
  - Highly scable and Fault tolerant.
  - Supports both Schema and Schemaless configuration.
  - Rich document parsing (pdf, word, images etc)

### Glossary

- schema.xml : contains fields which should be indexed in solr.
- solrconfig.xml : contains config's needed to run solr.
- Core : when solr server is started in standalone mode the configuration is called core.
- Collection: when solr server is started in SolrCloud mode the configuration is called collection.
- instancedir: configuration files for a collections are managed as part of instance directory.

### Configurations

- Configuring Solr
  - Schema.xml
    - contains fields which should be indexed in solr.
  - Solrconfig.xml
    - hdfs location is mentioned
    - Lucene index params
    - Request handler mappings
    - Cache seetings
    - Plugins

- Query Parser
  - Query is intreprted by QueryParser (default is lucene parser).    

- Solr Architectures
  - Simple
  - Multicore
  - Replication
  - Sharded

- Solr Caching
  - Filter Cache
  - Query Result Cache

### Integrations

- SolrCloud (Solr + zookeeper)
- Large Scale indexing (Solr + hadoop)
- index streaming data (spark streaming + solr)
- Reading data from solr into spark (solr + spark)- Query Solr from spark (solr + spark sql)
- Searching Cassandra with solr (cassandra + solr)
- Integrate Solr with HDFS (solr + hdfs)
  - Read and Write indexs to HDFS.
  - If you have a HDFS cluster already setup, you can use same for storing solr index.
  - Performance is not good since hdfs is not random access and append only file system.
  - Can implement Block Cache in HDFS using Apache Blur for faster performance.
  - Solr Node will write to HDFS node (i.e LFS of Data Node).
  - Integrate with zoo keeper (leader read/write, replicas only read from HDFS)
- Integrate Solr with MapReduce
  -  




	

