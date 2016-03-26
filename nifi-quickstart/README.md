# Apache Nifi

## Nifi Cluster

* Master/Slave Architecture

## Nifi Cluster Glossary

* NiFi Cluster Manager(NCM): instance of Nifi which manages cluster.
* Nodes: where actual data runs & do actualy processing.
* Primary Node: where isolated processors run. Elected by NCM or user configured.
* Isolated Processors: processors that run only in primary node and not in all the nodes.
* Heartbeats: Nodes send heartbeats to NCM about their health.

