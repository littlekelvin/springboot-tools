package com.example.springboot.repository;

import com.example.springboot.BaseSpringTest;
import com.example.springboot.entity.Emp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public class EmpRepositoryTest extends BaseSpringTest {
    @Autowired
    EmpRepository empRepository;

    @Test
    public void find() {
        System.out.println(empRepository.findById(1l));
    }

    @Test
    public void save() {
        Emp emp = new Emp();
        emp.setName("Mike");
        emp.setPwd("234");
        emp.setAge(23);
        emp.setEmpDate(new Date());
        empRepository.save(emp);
    }

    @Test
    public void update() {
        Emp emp = empRepository.findById(3L).get();
        emp.setName("Mike2");
        emp.setPwd("ab232");
        emp.setAge(38);
        empRepository.save(emp);
    }
}