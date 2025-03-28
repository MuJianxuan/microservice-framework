package org.microservice.cache.controller;

import org.microservice.cache.entity.User;
import org.microservice.cache.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author create 2022/8/17 by rao
 */
@RequestMapping("user")
@RestController
public class UserController {
    @Resource
    private UserRepository userRepository;

    @GetMapping("{id}")
    public User getById(@PathVariable("id")Long id){
        return userRepository.getById(id);
    }


    @PostMapping
    public void addUser(@RequestBody User user){
        userRepository.add(user);
    }

}
