# nifi installation

## System Requirements
* Requires Java 7 or newer
* Operating Systems: Linux/Unix/Windows/Mac OS X

## Installation on Mac OSX or Unix/Linux

* If you have homebrew installed you can do
```
brew install nifi
```

* Otherwise you can download tar file and do the installation as below.you can go to <http://nifi.apache.org/download.html> and download the tarball.
* Mac users can use curl -O <url>.
```
curl -O https://archive.apache.org/dist/nifi/0.5.1/nifi-0.5.1-bin.tar.gz
```
* Unix/Linux user's can use wget <url>.
* Untar the tar file
```
tar zxvf nifi-0.5.1-bin.tar.gz
```
* changed to installed directory
```
cd nifi-0.5.1
```

## start services

* Start nifi
```
bin/nifi.sh start
```
* check if nifi is running
```
bin/nifi.sh status
```
* check the port on which nifi UI can be opened. You can change and restart nifi if you want.
```
cat conf/nifi.properties | grep nifi.web.http.port
```
* you are good to start nifi using
```
<http://localhost:8080/nifi/>
```

* you can see the logs through
```
tail ./logs/nifi-app.log
```





