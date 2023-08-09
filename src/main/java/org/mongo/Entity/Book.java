package org.mongo.Entity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.json.bind.annotation.JsonbProperty;

@MongoEntity(collection="books")
public class Book extends PanacheMongoEntity {
    @JsonbProperty("title")
    public String title;

    @JsonbProperty("author")
    public String author;

    @JsonbProperty("pages")
    public int pages;

    @JsonbProperty("genres")
    public String genres;

    @JsonbProperty("rating")
    public double rating;

    public Book(String title, String author, int pages, String genres, double rating) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genres = genres;
        this.rating = rating;
    }

    public Book() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

