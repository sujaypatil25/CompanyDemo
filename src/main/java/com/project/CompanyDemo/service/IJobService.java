package com.project.CompanyDemo.service;

import com.project.CompanyDemo.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IJobService {
    List<Job> getJob();

    void addJob(Job job);

    boolean deleteJob(Integer jobId);

    boolean updateJob(Integer jobId, Job job);

    Job getJobById(Integer jobId);
}
