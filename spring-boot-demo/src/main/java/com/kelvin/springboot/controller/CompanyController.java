package com.kelvin.springboot.controller;

import com.kelvin.springboot.entity.Company;
import com.kelvin.springboot.entity.Employee;
import com.kelvin.springboot.repository.CompanyRepository;
import com.kelvin.springboot.vo.EmployVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Kelvin Mai
 * @date 4/17/2019
 */
@RestController
@Api(value = "CompanyController", description = "Company Operation API", protocols = "http")
public class CompanyController {

    @Resource
    CompanyRepository companyRepository;

    @PostMapping("/company")
    public Company add(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @GetMapping("company/{id}")
    public Company findById(@PathVariable Long id) {
        Optional<Company> result = companyRepository.findById(id);
        return result.isPresent() ? result.get() : new Company();
    }
}
