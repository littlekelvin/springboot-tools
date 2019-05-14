package com.example.springboot.controller;

import com.example.springboot.vo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Kelvin Mai
 * @date 4/14/2019
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hellog, " + name;
    }

    // JSR 验证规范， hibernate validator
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUser(@Valid User user, BindingResult bindingResult) {
        System.out.println("user:" + user);
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.stream().forEach((error) -> {
                System.out.println(error.getCode() + ": " +error.getDefaultMessage());
            });
        }
    }


}
