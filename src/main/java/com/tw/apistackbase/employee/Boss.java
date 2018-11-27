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

    public boolean removeEmployee(int id) {
        Employee employee = getEmployeeByID(id);
        return employee == null ? false : employeeList.remove(employee);

    }

    public Employee changeEmployee(int id, Employee newEmployee) {
        Employee originalEmployee = getEmployeeByID(id);
        if (originalEmployee == null) {
            throw new RuntimeException("No such employee id.");
        }
        employeeList.remove(originalEmployee);
        employeeList.add(mergeEmployeeValues(originalEmployee, newEmployee));
        return newEmployee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getNextID() {
        return nextID;
    }

    private Employee getEmployeeByID(int id) {
        for (Employee employee : employeeList) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }

    private Employee mergeEmployeeValues(Employee originalEmployee, Employee newEmployee) {
        newEmployee.id = originalEmployee.id;
        return newEmployee;
    }
}
