package com.tw.apistackbase.controller;

import com.tw.apistackbase.employee.Boss;
import com.tw.apistackbase.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @DeleteMapping(path = "/Employee/{id}")
    public String delete(@PathVariable int id) {
        return boss.removeEmployee(id) ? "Employee removed successfully." : "No such employee";
    }

    @PutMapping(path = "/Employee/{id}")
    public Employee change(@PathVariable int id, @RequestBody Employee newEmployee) {
        try {
            return boss.changeEmployee(id, newEmployee);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }
}
