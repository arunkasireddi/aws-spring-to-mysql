package com.example.service;

import com.example.domain.User;

import java.util.Collection;

public interface UserService {

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    Collection<User> getAllUsers();
}
