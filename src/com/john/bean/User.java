package com.john.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private Integer gender;
    private String name;
    private String email;
    private String lastName;
    private Department department;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                '}';
    }

    public User() {
    }

    public User(Integer id, Integer gender, String name, String email, String lastName, Department department) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.department = department;
    }

    public User(Integer id, Integer gender, String name, String email, String lastName) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
