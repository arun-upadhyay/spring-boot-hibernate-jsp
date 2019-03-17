package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public List<User> findUserById(String id);
    public void deleteUserById(String id);
    public  User editUserById(String id);
    public void saveUser(User user);

}
