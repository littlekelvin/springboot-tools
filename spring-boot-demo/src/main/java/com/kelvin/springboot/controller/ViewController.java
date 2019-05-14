package com.kelvin.springboot.controller;

import com.kelvin.springboot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Kelvin Mai
 * @date 4/17/2019
 */

@Controller
public class ViewController {

    @Resource
    EmployeeService employeeService;

    @GetMapping("/index")
    public String index(ModelMap model) throws UnknownHostException {
        String ip = "Host IP: " + InetAddress.getLocalHost().getHostAddress();
        String host = "Host: " + InetAddress.getLocalHost().getHostName();
        model.addAttribute("emps", employeeService.findAll());
        model.addAttribute("hostIp", ip);
        model.addAttribute("hostName", host);
        return "index";
    }

    @GetMapping("/home")
    public String home() throws UnknownHostException {
        return "home";
    }
}
