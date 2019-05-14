package com.example.springboot.mongodb.repository;

import com.example.springboot.mongodb.entity.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Component
public class UserRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void save(User user) {
        mongoTemplate.save(user);
    }

    public User findById(long id) {
        return mongoTemplate.findById(id, User.class);
    }

    public long updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName()).set("createTime", user.getCreateTime());
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result == null ? 0 : result.getMatchedCount();
    }

    public void deleteById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
