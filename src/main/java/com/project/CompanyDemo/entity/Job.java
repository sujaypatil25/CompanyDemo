package com.project.CompanyDemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer JobId;
    private String JobName;
    private Integer JobSalary;

//    @ManyToOne
//    //@JoinColumn(name = "companyId")
//    private Company company;
}
