package org.mongo.Entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
@MongoEntity(collection = "employee")
public class Employee {

        private String name;


        private String code;


        private String departmentId;


        private String phoneNumber;

    public Employee(String name, String code, String departmentId, String phoneNumber) {
        this.name = name;
        this.code = code;
        this.departmentId = departmentId;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

