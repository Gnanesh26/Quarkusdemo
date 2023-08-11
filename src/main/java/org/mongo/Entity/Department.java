package org.mongo.Entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.json.bind.annotation.JsonbProperty;

@MongoEntity(collection = "department")
public class Department {

    @JsonbProperty("department_name")
    private String departmentName;

    @JsonbProperty("department_hod")
    private String departmentHOD;
}