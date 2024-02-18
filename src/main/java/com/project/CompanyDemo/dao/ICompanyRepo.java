package com.project.CompanyDemo.dao;

import com.project.CompanyDemo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepo extends JpaRepository<Company,Integer>{
}
