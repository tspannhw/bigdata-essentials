# MongoDB 

## Installation

Download the jar file

```bash
curl -O https://fastdl.mongodb.org/osx/mongodb-osx-x86_64-3.4.3.tgz
```

Untar the file

```bash
tar -zxvf mongodb-osx-x86_64-3.4.3.tgz
```

Rename to mongodb and update PATH variable in .bash_profile

```bash
mv mongodb-osx-x86_64-3.4.3 mongodb
export PATH=<mongodb-install-directory>/bin:$PATH
```

Create data directory and make sure your user had permissions. This is the directory where mongod writes its data.

```bash
sudo mkdir -p /data/db
sudo chown user_name /data/db
```

Run mongod

```bash
mongod
```

The above step will pause at "waiting for connections on port 27017". If you want to return to the terminal you need to do some tweak to mongod command and run it as background and return to terminal as below.

```bash
mongod --dbpath /data/db/ --fork --logpath ~/mongod_log.log
```

To login to mongodb terminal

```bash
mongo
```

## Commands

Show databases

```bash
show dbs
```

create a database

```bash
## it will create and switch to the database
create mycustomers
```

```bash
## To know which database were you in
db
```

Collections are similar to tables in relational space.

```bash
db.createCollection('customers')
```

Show collections

```bash
show collections
```

Insert a document into collection

```bash
db.customers.insert({first_name:"ray",last_name:"smith"})
```

Query the collection

```bash
db.customers.find()
```

Insert multiple documents at once

```bash
db.customers.insert([{first_name:"John",last_name:"Dew"},{first_name:"kevin",last_name:"mux"}])
```

Prettify the output
```bash
db.customers.find().pretty()
```

Update total document

```bash
db.customers.update({first_name:"ray"},{first_name:"rob",last_name:"smith",gender:"male"})
```

update only few keys in json

```bash
db.customers.update({first_name:"rob"},{$set:{first_name:"ryan"}})
```


Add salary column for john and increment it

```bash
db.customers.update({first_name:"John"},{$set:{salary:110000}})

db.customers.update({first_name:"John"},{$inc:{salary:5000}})
```

Find Customers with salary less than

```bash
db.customers.find({salary:{$lt:112000}})
```

Remove the salary column of john

```bash
db.customers.update({first_name:"John"},{$unset:{salary:1}})
```

If it didn't find any documents, it wont insert new one by default

```bash
db.customers.update({first_name:"Jack"},{first_name:"Jack",last_name:"Mi"})

WriteResult({ "nMatched" : 0, "nUpserted" : 0, "nModified" : 0 })
```

If you want to do upsert(insert or update if matches)

```bash
db.customers.update({first_name:"Jack"},{first_name:"Jack",last_name:"Mi"},{upsert:true})

WriteResult({
	"nMatched" : 0,
	"nUpserted" : 1,
	"nModified" : 0,
	"_id" : ObjectId("58e66fc8c0fe2b76ef983130")
})
```

To rename any column

```bash
db.customers.update({first_name:"ryan"},{$rename:{"gender":"sex"}})
```

To remove a document that matches a criteria

```bash
db.customers.remove({first_name:"ryan"})

WriteResult({ "nRemoved" : 1 })
```

Delete only first one it finds

```bash
db.customers.remove({first_name:"ryan"},{justOne:true})
```

Using or condition during find

```bash
db.customers.find({$or:[{first_name:"John"},{first_name:"kevin"}]})
```

Using and condition during find

```bash
db.customers.find({$and:[{first_name:"John"},{last_name:"Dew"}]})
```

Insert a nested document

```bash
db.customers.insert({
	first_name:"John",
	last_name:"Guffin",
	phones:["1234567899","234567899"],
	address:{
		street:"Grey street",
		City:"Houston"
	}
})
```

Query a nested document

```bash
db.customers.find({"address.City":"Houston"})
```

Search if an array contains required data

```bash
db.customers.find({"phones":"1234567899"})

{ "_id" : ObjectId("58e6747c33b50bb38c9f7411"), "first_name" : "John", "last_name" : "Guffin", "phones" : [ "1234567899", "234567899" ], "address" : { "street" : "Grey street", "City" : "Houston" } }
```

Sort in ascending order

```bash
# 1 indicates ascending order below

db.customers.find().sort({"first_name":1})
```

Sort in descending order

```bash
# 1 indicates ascending order below

db.customers.find().sort({"first_name":-1})
```

Count no of documents

```bash
db.customers.find().count()
```

limit no of documents

```bash
db.customers.find().limit(2)
```

limit and sort

```bash
db.customers.find().limit(2).sort({"first_name":-1})
```

print any columns you want using function and foreach

```bash
db.customers.find().forEach(function(doc){ print("Name: " + doc.first_name + " " + doc.last_name)})
```

## Simple mongo db app

TODO

## MongoDB using Spring-boot

#### Sample Project

#### Edit application.properties

```bash
#mongodb
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=needforcode

#logging
logging.level.org.springframework.data=debug
logging.level.=error

```  

### How to run

Clone the above project, cd into it and run below command.

```bash
mvn spring-boot:run
```

This command should launch the server, deploy spring boot and connect to mongo db instance in the application.properties.

### Access rest using postman

Download postman client and send GET/POST requests as below.

![hello](springsrc/docs/images/mongo_spring_boot_hello.png)

