package com.project.CompanyDemo.controller;

import com.project.CompanyDemo.entity.Company;
import com.project.CompanyDemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getCompanies(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") Integer companyId) {
        boolean removed = companyService.deleteCompany(companyId);
        if (removed)
            return new ResponseEntity<>("Company with id: " + companyId + " removed.", HttpStatus.OK);
        else
            return new ResponseEntity<>("No Company with id: " + companyId, HttpStatus.NOT_FOUND);
    }

    @PutMapping("{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Integer companyId, @RequestBody Company company){
        if(companyService.updateCompany(companyId, company))
            return new ResponseEntity<>("Company with id: " + companyId + " updated.", HttpStatus.OK);
        else
            return new ResponseEntity<>("No Company with id: " + companyId, HttpStatus.NOT_FOUND);
    }

}
