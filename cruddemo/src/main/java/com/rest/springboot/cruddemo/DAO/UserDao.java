package com.rest.springboot.cruddemo.DAO;

import com.rest.springboot.cruddemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findById(int theId);
    public void save(User theUser);
    public void deleteById(int theId);
    public List<User> findAllByPage();
    public List<User> findByTechId(int theId);

}
