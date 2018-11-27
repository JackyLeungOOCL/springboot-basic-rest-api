package com.tw.apistackbase.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Boss {
    private List<Employee> employeeList;
    private int nextID;

    public Boss() {
        employeeList = new ArrayList<>();
        nextID = 0;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        nextID++;
    }

    public boolean removeEmployee(Employee employee) {
        if (employeeList.contains(employee)) {
            return false;
        }
        employeeList.remove(employee);
        return true;

    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getNextID() {
        return nextID;
    }
}
