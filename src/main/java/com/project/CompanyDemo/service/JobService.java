package com.project.CompanyDemo.service;

import com.project.CompanyDemo.dao.JobDao;
import com.project.CompanyDemo.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService{
    @Autowired
    JobDao jobDao;

    @Override
    public List<Job> getJob() {
        return jobDao.getJobList();
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
    }

    @Override
    public boolean deleteJob(Integer jobId) {
        return jobDao.deleteJob(jobId);
    }

    @Override
    public boolean updateJob(Integer jobId, Job job) {
        return jobDao.updateJob(jobId,job);
    }

    @Override
    public Job getJobById(Integer jobId) {
        return jobDao.getJobById(jobId);
    }
}
