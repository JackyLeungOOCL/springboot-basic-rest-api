package com.tw.apistackbase;

import com.tw.apistackbase.controller.CompanyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Society {
    private List<Company> companyList;
    private int nextID;


    public Society() {
        companyList = new ArrayList<>();
        companyList.add(new Company());
        companyList.add(new Company());
        companyList.add(new Company());
        nextID = 0;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public Company getCompanyByID(int id) {
        for (Company company : companyList) {
            if (company.id == id) {
                return company;
            }
        }
        throw new RuntimeException("No such company id.");
    }

    public void addCompany(Company company) {
        company.id = nextID++;
        companyList.add(company);
    }

//    public void removeCompany() {
//
//    }


    public int getNextID() {
        return nextID;
    }
}
