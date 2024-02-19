package com.project.CompanyDemo.service;

import com.project.CompanyDemo.dao.IJobRepo;
import com.project.CompanyDemo.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService{
    @Autowired
    IJobRepo jobDao;

    @Override
    public List<Job> getJob() {
        return jobDao.findAll();
    }

    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    @Override
    public boolean deleteJob(Integer jobId) {
        if (jobDao.findById(jobId).isPresent()) {
            jobDao.deleteById(jobId);
            return true;
        } else
            return false;
    }

    @Override
    public Job findJobById(Integer jobId) {
        Job job = jobDao.findById(jobId).orElse(null);
        if (job != null)
            return job;
        else
            return null;
    }

    @Override
    public boolean updateJob(Integer jobId, Job job) {
        Job newJob = findJobById(jobId);
        if (newJob != null) {
            newJob.setJobName(job.getJobName());
            newJob.setJobSalary(job.getJobSalary());
            jobDao.save(newJob);
            return true;
        } else
            return false;
    }
}
