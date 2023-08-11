package org.mongo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="posts")

public class Post extends PanacheMongoEntity {

    public String title;
    public String content;


    public ObjectId author;

    public Post(String title, String content, ObjectId author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjectId getAuthor() {
        return author;
    }

    public void setAuthor(ObjectId author) {
        this.author = author;
    }
}
