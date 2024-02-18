package com.project.CompanyDemo.service;


import com.project.CompanyDemo.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getCompanies();

    void addCompany(Company company);

    boolean deleteCompany(Integer companyId);

    boolean updateCompany(Integer companyId, Company company);
}
