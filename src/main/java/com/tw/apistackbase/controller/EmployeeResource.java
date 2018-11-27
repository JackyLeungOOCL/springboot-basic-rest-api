package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private Company company;

    public EmployeeResource(Company company) {
        this.company = company;
    }

    @GetMapping(produces = {"application/json"})
    public @ResponseBody List<Employee> getAll() {
        return company.getEmployees();
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public @ResponseBody Employee get(@PathVariable int id) {
        try {
            return company.getEmployeeByID(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PostMapping()
    public Employee add(@RequestBody Employee newEmployee) {
        newEmployee.id = company.getNextID();
        company.addEmployee(newEmployee);
        return newEmployee;
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable int id) {
        try {
            company.removeEmployee(id);
            return "Employee removed successfully.";
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping(path = "/{id}")
    public Employee change(@PathVariable int id, @RequestBody Employee newEmployee) {
        try {
            return company.changeEmployee(id, newEmployee);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }


}
