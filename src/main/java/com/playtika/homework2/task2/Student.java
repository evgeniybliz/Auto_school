package com.playtika.homework2.task2;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return String.format("Студент: " + id + " " + firstName + " " + lastName + " " + age);
    }
}