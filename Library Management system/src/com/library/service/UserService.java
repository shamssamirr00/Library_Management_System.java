package com.library.service;

import com.library.model.User;
import com.library.repository.UserRepository;


import java.util.ArrayList;
import java.util.HashSet;

public class UserService {
    private UserRepository userRepository;
    private HashSet<String> usersIds;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        usersIds = new HashSet<>();
    }
    public boolean registerUser(User user) {
        if(usersIds.contains(user.getId())) {
            return false;
        }
        userRepository.addUser(user);
        usersIds.add(user.getId());
        return true;
    }
    public User findUserById(String id) {

        return userRepository.findById(id);
    }
    public ArrayList<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
