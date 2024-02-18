package com.project.CompanyDemo.controller;

import com.project.CompanyDemo.entity.Company;
import com.project.CompanyDemo.entity.Job;
import com.project.CompanyDemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs/")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getJob() {
        return new ResponseEntity<>(jobService.getJob(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        jobService.addJob(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @DeleteMapping("{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable("jobId") Integer jobId) {
        boolean removed = jobService.deleteJob(jobId);
        if (removed)
            return new ResponseEntity<>("Job with id: " + jobId + " removed.", HttpStatus.OK);
        else
            return new ResponseEntity<>("No Job with id: " + jobId, HttpStatus.NOT_FOUND);
    }

    @PutMapping("{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Integer jobId, @RequestBody Job job){
        if(jobService.updateJob(jobId, job))
            return new ResponseEntity<>("Job with id: " + jobId + " updated.", HttpStatus.OK);
        else
            return new ResponseEntity<>("No Job with id: " + jobId, HttpStatus.NOT_FOUND);
    }

    @GetMapping("{jobId}")
    public ResponseEntity<Job> findJobById(@PathVariable Integer jobId){
        return new ResponseEntity<>(jobService.findJobById(jobId),HttpStatus.OK);
    }
}
