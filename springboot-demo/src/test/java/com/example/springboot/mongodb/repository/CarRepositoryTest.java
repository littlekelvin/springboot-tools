package com.example.springboot.mongodb.repository;

import com.example.springboot.BaseSpringTest;
import com.example.springboot.mongodb.entity.Car;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public class CarRepositoryTest extends BaseSpringTest {
    @Autowired
    CarRepository carRepository;

    @Test
    public void save() {
        Car car = new Car();
        car.setBuyDate(new Date());
        car.setCarName("BTW");
        car.setCost(2345.7);
        car.setSize(5);
        carRepository.save(car);
    }

    @Test
    public void update() {
        Car car = carRepository.findById(new ObjectId("5cb991c4ac81625acc8326a6")).get();
        car.setBuyDate(new Date());
        car.setCarName("BTW GGG");
        car.setCost(777.67);
        car.setSize(9);
        carRepository.save(car);
    }

    @Test
    public void find() {
        System.out.println(carRepository.findById(new ObjectId("5cb491b7820e866f9cc93da7")));
    }

    @Test
    public void delete() {
        carRepository.deleteById(new ObjectId("5cb491b7820e866f9cc93da7"));
    }
}