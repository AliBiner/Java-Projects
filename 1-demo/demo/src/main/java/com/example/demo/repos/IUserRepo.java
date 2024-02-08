package com.example.demo.repos;

import com.example.demo.entiy.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepo extends MongoRepository<User,String> {
}
