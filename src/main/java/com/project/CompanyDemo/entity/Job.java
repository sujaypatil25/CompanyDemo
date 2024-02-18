package com.project.CompanyDemo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Job {
    private Integer JobId;
    private String JobName;
    private Integer JobSalary;
}
