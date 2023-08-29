package org.mongo.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;



import java.util.List;

@Entity
@Table(name="writer")
public class Writer  extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    @OneToMany(mappedBy = "writer")
    public List<Books> books;

    public Writer(Integer id, String name, List<Books> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Writer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
