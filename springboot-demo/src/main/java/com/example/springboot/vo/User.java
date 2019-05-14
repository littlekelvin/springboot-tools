package com.example.springboot.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author Kelvin Mai
 * @date 4/14/2019
 */
public class User {
    @NotEmpty(message = "name can not be empty")
    private String name;
    @NotEmpty(message = "password can not be empty")
    @Length(max = 8, message = "password can not exceed 8 char")
    private String password;
    @Max(value = 100, message = "max 100")
    @Min(value = 18, message = "min 18")
    private int age;

    public User(@NotEmpty(message = "name can not be empty") String name, @NotEmpty(message = "password can not be empty") @Length(max = 8, message = "password can not exceed 8 char") String password, @Max(value = 100, message = "max 100") @Min(value = 18, message = "min 18") int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
