package com.project.CompanyDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    private Integer companyId;
    private String companyName;
    private String companyLocation;

    private List<Integer> jobIdList;
}
