package com.elasticsearch.elasticlombok.controller;

import com.elasticsearch.elasticlombok.entity.User;
import com.elasticsearch.elasticlombok.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController //Classımızın controller olduğunu belirtiyoruz
//@RequiredArgsConstructor -> Sadece finalların constructorını oluşturur.
@RequestMapping("/user")
//normalde url'de localhost:8080/UserController/ gibi yazılmalı ama bu güzel bir yöntem olmadığı için url'i customize ediyoruz. artık localhost:8080/user/ şeklinde erişim yapabiliriz.
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        System.out.println("Burada");
        this.userRepository = userRepository;
        User user = new User();
        user.setName("Test1");
        user.setSurname("Test1");
        user.setAddress("Test1");
        user.setBirthDate(new Date());
        userRepository.save(user);

        User user2 = new User();
        user2.setName("Test1");
        user2.setSurname("Test1");
        user2.setAddress("Test1");
        user2.setBirthDate(new Date());
        userRepository.save(user2);
    }


    @GetMapping("/{search}")
    @Async
    public CompletableFuture<ResponseEntity<List<User>>> GetAllAsync(@PathVariable String search) {

        List<User> users = (List<User>) userRepository.getByCustomQuearyAsync(search);
        return CompletableFuture.completedFuture(ResponseEntity.ok(users));
    }

    @GetMapping("/get")
    @Async
    public CompletableFuture<ResponseEntity<List<User>>> GetAllAsync(@RequestBody User user){
        List<User> users = userRepository.findByNameContainsOrSurnameContains(user.getName(),user.getSurname());
        return CompletableFuture.completedFuture(ResponseEntity.ok(users));
    }


}
