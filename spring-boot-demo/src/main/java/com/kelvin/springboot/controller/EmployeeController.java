package com.kelvin.springboot.controller;

import com.kelvin.springboot.entity.Employee;
import com.kelvin.springboot.service.EmployeeService;
import com.kelvin.springboot.vo.EmployVO;
import com.kelvin.springboot.vo.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
@RestController
@Api(value = "EmployeeController", description = "Employee Operation API", protocols = "http")
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @GetMapping("/emps")
    @ApiOperation(value = "All employee list", notes = "Complete employee list", response = List.class,
            produces = "application/json")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/emp")
    @ApiOperation(value = "add employee", notes = "Add new employee", response = Employee.class,
            produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "employee id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "eName", value = "employee title", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cardNumber", value = "employee cardNumber", required = false, dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "request success"),
            @ApiResponse(code = 302, message = "request redirect"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "request forbidden"),
            @ApiResponse(code = 404, message = "resource not found")
    })
    public Employee add(@RequestBody EmployVO employVO){
        return employeeService.add(employVO);
    }

    @PutMapping("/emp")
    public Employee update(@RequestBody EmployVO employVO){
        return employeeService.update(employVO);
    }

    @GetMapping("emp/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("emp/{id}")
    public ResponseResult deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        ResponseResult re = new ResponseResult();
        re.setCode(200);
        re.setMessage("success");
        return re;
    }
}
