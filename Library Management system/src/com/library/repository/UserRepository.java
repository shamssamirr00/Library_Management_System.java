package com.library.repository;

import com.library.model.User;
import java.util.ArrayList;

public interface UserRepository {
    void addUser(User user);
    User findById(String id);
    ArrayList<User> findAllUsers();
}
