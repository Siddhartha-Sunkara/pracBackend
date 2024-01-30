package com.daoprac.dao.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_records")

public class Student {
    @Id
    private int roll;

    private String name;

    private String city;

    public Student(){}

    public Student(int roll, String name, String city) {
        this.roll = roll;
        this.name= name;
        this.city= city;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
