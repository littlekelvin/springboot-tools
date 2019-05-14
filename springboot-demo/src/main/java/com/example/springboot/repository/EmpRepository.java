package com.example.springboot.repository;

import com.example.springboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Component
public interface EmpRepository extends JpaRepository<Emp, Long> {

}
