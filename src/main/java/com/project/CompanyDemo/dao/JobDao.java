package com.project.CompanyDemo.dao;

import com.project.CompanyDemo.entity.Job;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JobDao {

    private List<Job> jobList=new ArrayList<>(Arrays.asList(
            new Job(1,"Java Developer", 100000),
            new Job(2,"Python Developer", 80000),
            new Job(3,"Salesforce Developer", 50000),
            new Job(4,"C++ Developer", 70000),
            new Job(5,"DotNet Developer", 90000)
    ));

    public List<Job> getJobList() {
        return jobList;
    }

    public void addJob(Job job) {
        jobList.add(job);
    }

    public boolean deleteJob(Integer compId) {
        return jobList.removeIf(job -> job.getJobId().equals(compId));
    }

    public boolean updateJob(Integer compId, Job newJob) {
        boolean updated=false;
        for(Job job: jobList){
            if(job.getJobId() == compId){
                job.setJobName(newJob.getJobName());
                job.setJobSalary(newJob.getJobSalary());
                updated=true;
            }
        }
        return updated;
    }

    public Job getJobById(Integer jobId){
        Optional<Job> jobById= jobList.stream().filter(x->x.getJobId().equals(jobId)).findFirst();
        return jobById.orElse(null);
    }
}
