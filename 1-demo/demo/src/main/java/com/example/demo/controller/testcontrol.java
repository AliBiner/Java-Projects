package com.example.demo.controller;

import com.example.demo.entiy.User;
import com.example.demo.repos.IUserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class testcontrol {

    @Autowired
    private IUserRepo userRepo;

    @PostMapping("/create")
    public ResponseEntity<User> Create(@RequestBody User user){
        return ResponseEntity.ok(userRepo.save(user));
    }

    @GetMapping( "/get-all")
    public ResponseEntity<List<User>> GetAll(){
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Optional<User>> GetById(@RequestBody User user){
        return ResponseEntity.ok(userRepo.findById(user.getId()));
    }



    


}
