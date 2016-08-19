package com.needforcode.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Simple App connecting to mongodb
 *
 */
public class MongoApp {

    public static void main(String[] args) throws Exception {

        try {

            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            MongoDatabase db = mongoClient.getDatabase("needforcode");

            // get a single collection
            MongoCollection collection = db.getCollection("employee");

            // create DB object
            BasicDBObject doc = new BasicDBObject("empId", "123")
                .append("empName","jim")
                .append("empPhone","12345")
                .append("empEmail","jim@needforcode.com");

            collection.insertOne(new Document(doc));

            FindIterable result = collection.find().limit(1);

            System.out.println(result.first());

            System.out.println("Done");

        }  catch (MongoException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
            throw new Exception("unknown host");
        }

    }

}
