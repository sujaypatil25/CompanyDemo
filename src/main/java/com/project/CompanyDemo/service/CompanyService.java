package com.project.CompanyDemo.service;

import com.project.CompanyDemo.dao.ICompanyRepo;
import com.project.CompanyDemo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyRepo companyDao;

    @Override
    public List<Company> getCompany() {
        return companyDao.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyDao.save(company);
    }

    @Override
    public boolean deleteCompany(Integer companyId) {
        if (companyDao.findById(companyId).isPresent()) {
            companyDao.deleteById(companyId);
            return true;
        } else
            return false;
    }

    @Override
    public Company findCompanyById(Integer companyId) {
        Company company = companyDao.findById(companyId).orElse(null);
        if (company != null)
            return company;
        else
            return null;
    }

    @Override
    public boolean updateCompany(Integer companyId, Company company) {
        Company newCompany = findCompanyById(companyId);
        if (newCompany != null) {
            companyDao.save(company);
            return true;
        } else
            return false;
    }
}
