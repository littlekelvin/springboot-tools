package com.kelvin.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Kelvin Mai
 * @date 4/17/2019
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) throws UnknownHostException {
        return "Hello Docker, Current Host: " + InetAddress.getLocalHost().getHostAddress() + "(" + InetAddress.getLocalHost().getHostName() + ")";
    }


}
