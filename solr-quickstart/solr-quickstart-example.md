## solr quickstart example

### Hardware used

```bash
System Version: OS X 10.10.5
java version "1.7.0_80"
```

### Download solr

- Download solr
```bash
curl -O "http://archive.apache.org/dist/lucene/solr/5.3.0/solr-5.3.0.zip"
```
- unzip solr
```bash
 unzip solr-5.3.0.zip # unzip the zip file
 cd solr-5.3.0
 ```

### Running Solr

- start solr
```bash
bin/solr start

Started Solr server on port 8983
```

- To see options in solr script
```bash
bin/solr -help
```

- To check if solr is running
```bash
bin/solr status
```

### Create Core

- To create Core
```bash
bin/solr create -c example_core
```
- Output should look like
```bash
Setup new core instance directory:
/Users/solr_user/solr-5.3.0/server/solr/example_core

Creating new core 'example_core' using command:
http://localhost:8983/solr/admin/cores?action=CREATE&name=example_core&instanceDir=example_core

{
  "responseHeader":{
    "status":0,
    "QTime":2069},
  "core":"example_core"}
```

- Use the post script to post files to core.
```bash
bin/post -c example_core example/exampledocs/*.xml
```

### Query the results

```html
http://localhost:8983/solr/example_core/select?q=video
```








