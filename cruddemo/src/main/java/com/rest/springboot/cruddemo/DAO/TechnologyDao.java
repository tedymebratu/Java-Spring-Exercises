package com.rest.springboot.cruddemo.DAO;

import com.rest.springboot.cruddemo.Entity.Technology;
import com.rest.springboot.cruddemo.Entity.User;

import java.util.List;

public interface TechnologyDao {
    public List<Technology> findAll();
    public Technology findById(int theId);
    public void save(Technology theTechnology);
    public void deleteById(int theId);
}
