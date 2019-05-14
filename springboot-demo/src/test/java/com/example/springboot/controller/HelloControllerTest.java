package com.example.springboot.controller;

import com.example.springboot.bo.Prop;
import com.example.springboot.bo.PropTest;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Kelvin Mai
 * @date 4/14/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    Prop prop;

    @Autowired
    PropTest propTest;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void helloHttp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=kelvin")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("kelvin")));
    }

    @Test
    public void saveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                .param("name", "")
                .param("age", "13")
                .param("password", "1234567890"));
    }

    @Test
    public void configValue() {
        System.out.println(prop.getName());
        System.out.println(prop.getDesc());
    }

    @Test
    public void configValue2() {
        System.out.println(propTest.getName());
        System.out.println(propTest.getDesc());
        System.out.println(propTest.getAge());
    }
}