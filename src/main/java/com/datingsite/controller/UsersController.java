package com.datingsite.controller;

import com.datingsite.dto.UserDto;
import com.datingsite.dto.UserLoginData;
import com.datingsite.entities.User;
import com.datingsite.exceptions.ServerException;
import com.datingsite.logic.UsersLogic;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersLogic usersLogic;

    @Autowired
    public UsersController(UsersLogic usersLogic){
        this.usersLogic = usersLogic;
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws ServerException {
        usersLogic.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginData userLoginData) throws ServerException, JsonProcessingException {
        String token = usersLogic.login(userLoginData);
        return token;
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws ServerException {
        usersLogic.updateUser(user);
    }


    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") int userId) throws ServerException {
        usersLogic.removeUser(userId);
    }

    @GetMapping("{userId}")
    public UserDto getUser(@PathVariable("userId") int userId) throws ServerException {
        UserDto user = usersLogic.getUser(userId);
        return user;
    }

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam("page") int page) throws ServerException {
        List<UserDto> users = usersLogic.getAllUsers(page);
        return users;
    }
}

