package com.tw.apistackbase;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Company {
    private List<Employee> employees;
    private int nextID;
    public int id;
    public String name;
    public int employeesNumber;


    public Company() {
        employees = new ArrayList<>();
        nextID = 0;
    }

    public Company(int id, String name, int employeesNumber, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
        nextID = 0;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        nextID++;
    }

    public void removeEmployee(int id) {
        employees.remove(getEmployeeByID(id));
    }

    public Employee changeEmployee(int id, Employee newEmployee) {
        Employee originalEmployee = getEmployeeByID(id);
        employees.add(mergeEmployeeValues(originalEmployee, newEmployee));
        employees.remove(originalEmployee);
        return newEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getNextID() {
        return nextID;
    }

    public Employee getEmployeeByID(int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        throw new RuntimeException("No such employee id.");
    }

    private Employee mergeEmployeeValues(Employee originalEmployee, Employee newEmployee) {
        newEmployee.id = originalEmployee.id;
        return newEmployee;
    }
}
