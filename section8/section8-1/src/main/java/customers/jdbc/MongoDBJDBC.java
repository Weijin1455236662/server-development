package customers.jdbc;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBJDBC {
    public static void main(String args[]) {
        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);

            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

            MongoCollection<Document> collection = mongoDatabase.getCollection("mytable");

            collection.deleteMany(Filters.eq("name", "taozs"));

            //插入
            Document document = new Document("name", "taozs").
                    append("age", 18).
                    append("memo", "taozhaosheng");

            List<Document> documents = new ArrayList<>();
            documents.add(document);
            collection.insertMany(documents);

            //删除符合条件的第一个文档
//            collection.deleteOne(Filters.eq("age", 18));

            //删除所有符合条件的文档
//            collection.deleteMany(Filters.eq("age", 18));

            //查询
            FindIterable<Document> findIterable = collection.find();

            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                Document doc =mongoCursor.next();
                System.out.println(doc);
                System.out.println(doc.toJson());
            }

            mongoClient.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
