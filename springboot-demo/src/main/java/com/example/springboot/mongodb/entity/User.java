package com.example.springboot.mongodb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
