package com.rest.springboot.cruddemo.ServiceImpl;

import com.rest.springboot.cruddemo.DAO.TechnologyDao;
import com.rest.springboot.cruddemo.Entity.Technology;
import com.rest.springboot.cruddemo.Service.TechnologyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private TechnologyDao technologyDao;

    public TechnologyServiceImpl(TechnologyDao theTechnologyDao){
        technologyDao=theTechnologyDao;
    }

    @Override
    @Transactional
    public List<Technology> findAll() {
        return technologyDao.findAll();
    }

    @Override
    @Transactional
    public Technology findById(int theId) {
        return technologyDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Technology theTechnology) {
        technologyDao.save(theTechnology);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        technologyDao.deleteById(theId);
    }
}
