package com.example.springboot.bo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Mai
 * @date 4/14/2019
 */
@Component
public class Prop {
    @Value("${kelvin.name}")
    private String name;
    @Value("${kelvin.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
