package com.kelvin.springboot.repository;

import com.kelvin.springboot.common.BaseSpringContextTest;
import com.kelvin.springboot.entity.Company;
import com.kelvin.springboot.entity.Employee;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
public class EmployeeRepositoryTest extends BaseSpringContextTest {

    @Resource(name = "employeeRepository")
    EmployeeRepository employeeRepository;

    @Resource
    CompanyRepository companyRepository;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        Company company = new Company();
        company.setcName("OOCL");
        company.setCode("OOLU");
        company.setEstablishTime(new Date());
        company.getEmployees().add(employee);
        employee.setCompany(company);
        employee.setAge(23);
        employee.setEmpDate(new Date());
        employee.seteName("kelvin");
        employee.setPhoneNumber("10086");
        employee.setSalary(8000.23);

//        employeeRepository.save(employee);
        companyRepository.save(company);
    }

    @Test
    public void saveCompany() {
        Company company = new Company();
        company.setcName("COSCO");
        company.setCode("COSCON");
        company.setEstablishTime(new Date());
        companyRepository.save(company);
    }

    @Test
    public void save2() {
        Employee employee = new Employee();
        employee.setCompany(companyRepository.findById(1l).get());
        employee.setAge(23);
        employee.setEmpDate(new Date());
        employee.seteName("kelvin");
        employee.setPhoneNumber("10086");
        employee.setSalary(8000.23);
        employeeRepository.save(employee);
    }

    @Test
    public void testUpdate() {
        Optional<Employee> re = employeeRepository.findById(2L);
        if(re.isPresent()) {
            Employee emp = re.get();
            emp.setPhoneNumber("123456");
            emp.setSalary(9999.0);
            employeeRepository.save(emp);
        }
    }

    @Test
    public void delete() {
        employeeRepository.deleteById(2l);
    }

    @Test
    public void find() {
        Optional<Employee> re = employeeRepository.findById(2L);
        System.out.println(re.get());
    }
}