package org.mongo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

@MongoEntity(collection = "poems")
public class Poem extends PanacheMongoEntity {
       public String genre;

       @BsonProperty("poem_name")
       public String poemName;

       public  String language;

    public Poem(String genre, String poemName, String language) {
        this.genre = genre;
        this.poemName = poemName;
        this.language = language;
    }

    public Poem() {
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoemName() {
        return poemName;
    }

    public void setPoemName(String poemName) {
        this.poemName = poemName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
