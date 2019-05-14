package com.kelvin.springboot.service;

import com.kelvin.springboot.entity.Employee;
import com.kelvin.springboot.vo.EmployVO;

import java.util.List;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
public interface EmployeeService {

    List<EmployVO> findEmployWithCardInfo();

    List<Employee> findAll();

    Employee findById(Long id);

    Employee add(EmployVO employVO);

    Employee update(EmployVO employVO);

    void deleteById(Long id);
}
