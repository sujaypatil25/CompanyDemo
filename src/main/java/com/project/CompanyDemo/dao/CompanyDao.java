package com.project.CompanyDemo.dao;

import com.project.CompanyDemo.entity.Company;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Getter
public class CompanyDao {


    List<Company> companyList = new ArrayList<>(Arrays.asList(new Company(1, "Sapiens", "Bangalore"),
            new Company(2, "Allstate", "Pune"),
            new Company(3, "Google", "New York"),
            new Company(4, "Amazon", "Hyderabad"),
            new Company(5, "Facebook", "London")));

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public boolean deleteCompany(Integer compId) {
        return companyList.removeIf(company -> company.getCompanyId().equals(compId));
    }

    public boolean updateCompany(Integer compId, Company newCompany) {
        boolean updated=false;
        for(Company company: companyList){
            if(company.getCompanyId() == compId){
                company.setCompanyName(newCompany.getCompanyName());
                company.setCompanyLocation(newCompany.getCompanyLocation());
                updated=true;
            }
        }
        return updated;
    }
}
