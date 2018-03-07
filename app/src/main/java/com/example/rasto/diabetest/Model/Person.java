package com.example.rasto.diabetest.Model;

import android.util.Base64;

import java.util.UUID;

public class Person {

    private static Person instance;

    private String firstName;
    private String lastName;
    private String MiddleName;
    private double sugarLevel;
    private int age;
    private String stage;
    private UUID id;
    private Base64 password;
    private String email;

    private Person() {}

    public static synchronized Person getInstance() {
        if (instance == null) {
            instance = new Person();
        }
        return instance;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public double getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Base64 getPassword() {
        return password;
    }

    public void setPassword(Base64 password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
