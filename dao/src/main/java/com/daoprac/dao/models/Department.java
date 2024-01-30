package com.daoprac.dao.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {
    public Department(int roll, String department) {
        this.roll = roll;
        this.department = department;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int studentId) {
        this.roll = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Id
    private int roll;
    private String department;
}
