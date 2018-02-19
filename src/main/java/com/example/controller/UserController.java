package com.example.controller;

import com.example.assemblers.UserAssembler;
import com.example.domain.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;
import com.example.vo.CreateUserVO;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String hello()
    {
        return "Hello from Spring Boot Application to: Arun Kumar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserVO createUser(@RequestBody CreateUserVO userVO) {
        //convert to User
        User user = userAssembler.toUser(userVO);
        //save User
        User savedUser = userService.createUser(user);
        //convert to UserVO
        return userAssembler.toUserVO(savedUser);
    }
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return new ArrayList<User>(userService.getAllUsers());
    }

}