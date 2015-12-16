package com.pramati.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class MongoDbOperations {
	public static MongoCursor<Document> readAllDocumentsFromMongo(MongoCollection<Document> mongoCollection){
		return mongoCollection.find().iterator();
	}
}
