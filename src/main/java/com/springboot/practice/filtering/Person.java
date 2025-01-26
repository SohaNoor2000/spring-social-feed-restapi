package com.springboot.practice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"firstName"})
@JsonFilter("dynamicFilter")
public class Person {

//    @JsonIgnore
    private String firstName;

    private String lastName;
    
    private int age;

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        age = age;
    }

    public Person(String firstName, String lastName, int age){
        this.firstName =firstName;
        this.lastName =lastName;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
