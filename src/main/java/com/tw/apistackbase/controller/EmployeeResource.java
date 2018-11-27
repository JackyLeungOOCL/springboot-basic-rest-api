package com.tw.apistackbase.controller;

import com.tw.apistackbase.employee.Boss;
import com.tw.apistackbase.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private Boss boss;

    @Autowired
    public EmployeeResource(Boss boss) {
        this.boss = boss;
    }

    @GetMapping(path = "/AllEmployees", produces = {"application/json"})
    public @ResponseBody List<Employee> getAll() {
        return boss.getEmployeeList();
    }

    @PostMapping(path = "/Employee")
    public Employee add(@RequestBody Employee newEmployee) {
        newEmployee.id = boss.getNextID();
        boss.addEmployee(newEmployee);
        return newEmployee;
    }
}
