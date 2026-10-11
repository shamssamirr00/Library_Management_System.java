package com.library.repository;

import com.library.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserRepositoryImpl implements UserRepository {
    private ArrayList<User> users;
    private HashMap < String, User > userMap;

    public UserRepositoryImpl() {
        users = new ArrayList<>();
        userMap = new HashMap<>();
    }
    @Override
    public void addUser(User user) {
        users.add(user);
        userMap.put(user.getId() , user);
    }
    @Override
    public User findById(String id) {
        return userMap.get(id);
    }
    @Override
    public ArrayList < User > findAllUsers(){
        return users;
    }
}
