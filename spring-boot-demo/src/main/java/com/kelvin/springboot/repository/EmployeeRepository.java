package com.kelvin.springboot.repository;

import com.kelvin.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
@Component("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
