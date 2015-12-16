package com.pramati.mongodb;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbController {
	
	public static void main(String args[]){
		// MongoClient represents a pool of connections to the database
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		// MongoDatabase is an interface that helps us to connect to a database. If the database doesn't exist, it creates.
		MongoDatabase database = mongoClient.getDatabase("govt_of_india");
			
		// Gets a collection from the database.
		MongoCollection<Document> mongoCollection = database.getCollection("users");
		
		// To create document use Document class
		Document document = new Document("name", "dileep").append("age", 24);
		//inserts one document
		mongoCollection.insertOne(document);
		
		Document embeddedDocument = new Document("name", "Kumar")
				.append("age", 25)
				.append("skillset",new Document("technology","java").append("experience in years", 2));
		mongoCollection.insertOne(embeddedDocument);
		
		System.out.println("done adding documents...lets iterate them");
		MongoCursor<Document> mongoCursor = MongoDbOperations.readAllDocumentsFromMongo(mongoCollection);
		while(mongoCursor.hasNext()){
			System.out.println("->"+mongoCursor.next().toJson());
		}
	}
	
}
