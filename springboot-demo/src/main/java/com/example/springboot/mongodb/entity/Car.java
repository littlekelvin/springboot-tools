package com.example.springboot.mongodb.entity;

import com.example.springboot.audit.Auditable;
import com.example.springboot.audit.AuditableMongo;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Document("st_car")
public class Car extends AuditableMongo<String> {
    @Id
    private ObjectId id;
    @Field("car_name")
    private String carName;
    private Double cost;
    private Integer size;
    @Field("buy_date")
    private Date buyDate;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", cost=" + cost +
                ", size=" + size +
                ", buyDate=" + buyDate +
                '}';
    }
}
