package com.example.springboot.mongodb.repository;

import com.example.springboot.mongodb.entity.Car;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public interface CarRepository extends MongoRepository<Car, ObjectId> {

}
