package org.mongo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

@MongoEntity(collection = "poets")
public class Poet extends PanacheMongoEntity {


public String name;
public int age;
public  String mail;
public String gender;

public List<String> poems;

    public Poet(String name, int age, String mail, String gender, List<String> poems) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.gender = gender;
        this.poems = poems;
    }

    public Poet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getPoems() {
        return poems;
    }

    public void setPoems(List<String> poems) {
        this.poems = poems;
    }
}
