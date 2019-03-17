package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findUserById(String id) {
        List<User> listUsers = userDAO.findUserById(Integer.parseInt(id));
        return listUsers;
    }

    @Override
    public List<User> getUsers() {
        List<User> listUser = userDAO.findAll();
        return listUser;
    }

    public void deleteUserById(String id) {
        List<User> listUser = userDAO.findAll();
        for (User u : listUser) {
            if (u.getId() == Integer.parseInt(id)) {
                userDAO.delete(u);
            }
        }

    }

    @Override
    public User editUserById(String id) {
        User user = null;
        List<User> listUser = userDAO.findAll();
        for (User u : listUser) {
            if (u.getId() == Integer.parseInt(id)) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveAndFlush(user);
    }
}
