package com.project.CompanyDemo.service;

import com.project.CompanyDemo.dao.CompanyDao;
import com.project.CompanyDemo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public List<Company> getCompany() {
        return companyDao.getCompanyList();
    }

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public boolean deleteCompany(Integer companyId) {
        return companyDao.deleteCompany(companyId);
    }

    @Override
    public boolean updateCompany(Integer companyId, Company company) {
        return companyDao.updateCompany(companyId,company);
    }

}
