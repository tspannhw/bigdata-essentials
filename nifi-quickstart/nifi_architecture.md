
## Nifi Cluster

* Master/Slave Architecture

## Nifi glossary

### FlowFile: 
A smallest piece of data that flows which may represent xml/json message or unstructured
Flow file made of both contents of flow file & attributes (key values associated with data)

### Processor: 
Processor is responsible for performing following tasks. 

* bringing data into system
* pushing data into systems
* routing logic for data
* merging, splitting, transformation of data
            
### FlowFile Repository: 
Stores the FlowFiles' attributes and state.

### Content Repository:
Stores the contents of the flow files, ie actual data itself.

## Nifi Cluster

###  NiFi Cluster Manager(NCM)
instance of Nifi which manages cluster

###  Nodes
where actual data runs & do actualy processing.

### Primary Node
where isolated processors run. Elected by NCM or user configured.

### Isolated Processors
processors that run only in primary node and not in all the nodes.

### Heartbeats: 
Nodes send heartbeats to NCM about their health.
