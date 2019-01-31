package com.rest.springboot.cruddemo.ServiceImpl;

import com.rest.springboot.cruddemo.DAO.UserDao;
import com.rest.springboot.cruddemo.Entity.User;
import com.rest.springboot.cruddemo.Service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao theUserDao) {
        userDao=theUserDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(int theId) {
        return userDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theUser) {
        userDao.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        userDao.deleteById(theId);
    }

    @Override
    public List<User> findAllByPage() {
        return userDao.findAllByPage();
    }

    @Override
    public List<User> findByTechId(int theId) {
        return userDao.findByTechId(theId);
    }
}
