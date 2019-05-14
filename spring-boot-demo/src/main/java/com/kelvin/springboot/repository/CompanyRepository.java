package com.kelvin.springboot.repository;

import com.kelvin.springboot.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
@Component("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
