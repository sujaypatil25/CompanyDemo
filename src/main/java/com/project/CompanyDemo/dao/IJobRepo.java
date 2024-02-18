package com.project.CompanyDemo.dao;

import com.project.CompanyDemo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepo extends JpaRepository<Job,Integer> {
}
