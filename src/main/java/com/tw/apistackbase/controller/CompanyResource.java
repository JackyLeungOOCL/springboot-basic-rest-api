package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.Employee;
import com.tw.apistackbase.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
    private Society society;

    @Autowired
    public CompanyResource(Society society) {
        this.society = society;
    }

    @GetMapping(produces = {"application/json"})
    public @ResponseBody List<Company> getAll() {
        return society.getCompanyList();
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public Company get(@PathVariable int id) {
        try {
            return society.getCompanyByID(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @GetMapping(path = "/{id}/employees", produces = {"application/json"})
    public List<Employee> getEmployeesofCompany(@PathVariable int id) {
        try {
            return society.getCompanyByID(id).getEmployees();
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PostMapping()
    public Company add(@RequestBody Company newCompany) {
        newCompany.id = society.getNextID();
        society.addCompany(newCompany);
        return newCompany;
    }


}
