package com.tw.apistackbase.employee;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private List<Employee> employeeList;

    public Boss() {
        employeeList = new ArrayList<>();
        this.addEmployee(new Employee(0, "Xiaoming", 20, "Male"));
        this.addEmployee(new Employee(1, "Xiaohong", 19, "Female"));
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
