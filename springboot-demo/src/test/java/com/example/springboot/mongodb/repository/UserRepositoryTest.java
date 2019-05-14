package com.example.springboot.mongodb.repository;

import com.example.springboot.BaseSpringTest;
import com.example.springboot.mongodb.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public class UserRepositoryTest extends BaseSpringTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setId(111L);
        user.setName("kelvin");
        user.setCreateTime(new Date());
        userRepository.save(user);
    }

    @Test
    public void findById() {
        System.out.println(userRepository.findById(111l));
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(111L);
        user.setName("mike");
        user.setCreateTime(new Date());

        System.out.println(userRepository.updateUser(user));
    }

    @Test
    public void delete() {
        userRepository.deleteById(111l);
    }
}