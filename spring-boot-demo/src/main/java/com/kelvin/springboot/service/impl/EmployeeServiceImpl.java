package com.kelvin.springboot.service.impl;

import com.kelvin.springboot.entity.Employee;
import com.kelvin.springboot.repository.CompanyRepository;
import com.kelvin.springboot.repository.EmployeeRepository;
import com.kelvin.springboot.service.EmployeeService;
import com.kelvin.springboot.vo.EmployVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeRepository employeeRepository;
    @Resource
    CompanyRepository companyRepository;

    @Override
    public List<EmployVO> findEmployWithCardInfo() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Employee add(EmployVO employVO) {
        Employee e = new Employee();
        mapVoToDomain(employVO, e);
        e.setCompany(companyRepository.findById(employVO.getCompanyid()).get());
        return employeeRepository.save(e);
    }

    @Override
    public Employee update(EmployVO employVO) {
        if (employVO.getId() == null || employVO.getId() == 0) {
            return null;
        }
        Employee emp = this.findById(employVO.getId());
        mapVoToDomain(employVO, emp);
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    private void mapVoToDomain(EmployVO employVO, Employee e) {
        e.setSalary(employVO.getSalary());
        e.setPhoneNumber(employVO.getPhoneNumber());
        e.seteName(employVO.geteName());
        e.setEmpDate(employVO.getEmpDate());
        e.setAge(employVO.getAge());
        e.setCardNumber(employVO.getCardNumber());
    }
}
