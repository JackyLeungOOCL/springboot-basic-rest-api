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

    public void removeEmployee(int id) {
        employeeList.remove(getEmployeeByID(id));
    }

    public Employee changeEmployee(int id, Employee newEmployee) {
        Employee originalEmployee = getEmployeeByID(id);
        employeeList.add(mergeEmployeeValues(originalEmployee, newEmployee));
        employeeList.remove(originalEmployee);
        return newEmployee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getNextID() {
        return nextID;
    }

    public Employee getEmployeeByID(int id) {
        for (Employee employee : employeeList) {
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
