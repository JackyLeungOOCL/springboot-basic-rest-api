package com.tw.apistackbase.controller;

import com.tw.apistackbase.employee.Boss;
import com.tw.apistackbase.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @GetMapping(path = "/AllEmployees", produces = {"application/json"})
    public @ResponseBody List<Employee> getAll() {
        Boss boss = new Boss();
        return boss.getEmployeeList();
    }
}
