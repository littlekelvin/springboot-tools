package com.example.springboot.controller;

import com.example.springboot.entity.Emp;
import com.example.springboot.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@RestController
public class EmpController {
    @Autowired
    EmpRepository empRepository;

    @PostMapping("/emp")
    public Emp save(@RequestBody Emp emp) {
        System.out.println(emp);
//        emp.setEmpDate(new Date());
        Emp re = empRepository.save(emp);
        System.out.println(re);
        return re;
    }

    @GetMapping("emp/{id}")
    public Emp find(@PathVariable Long id) {
        return empRepository.findById(id).get();
    }
}
