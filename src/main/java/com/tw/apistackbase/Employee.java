package com.tw.apistackbase;


public class Employee {
    public int id;
    public String name;
    public int age;
    public String gender;
    public double salary;

    public Employee(int id, String name, int age, String gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
}
