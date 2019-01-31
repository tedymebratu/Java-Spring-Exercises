package com.rest.springboot.cruddemo.Service;

import com.rest.springboot.cruddemo.Entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(int theId);
    public void save(User theUser);
    public void deleteById(int theId);
    public List<User> findAllByPage();
    public List<User> findByTechId(int theId);
}
