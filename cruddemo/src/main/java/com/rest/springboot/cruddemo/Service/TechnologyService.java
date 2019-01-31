package com.rest.springboot.cruddemo.Service;

import com.rest.springboot.cruddemo.Entity.Technology;

import java.util.List;

public interface TechnologyService {
    public List<Technology> findAll();
    public Technology findById(int theId);
    public void save(Technology theTechnology);
    public void deleteById(int theId);
}
