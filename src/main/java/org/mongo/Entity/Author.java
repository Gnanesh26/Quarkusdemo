package org.mongo.Entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.util.List;

@MongoEntity(collection = "authors")
public class Author {
    public ObjectId _id;
    public String author;
    public int birth_year;
    public String nationality;
    public String description;
//    public List<ObjectId> books;
    public Author() {
    }

    public Author(ObjectId _id, String author, int birth_year, String nationality, String description) {
        this._id = _id;
        this.author = author;
        this.birth_year = birth_year;
        this.nationality = nationality;
        this.description = description;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}