package com.rest.springboot.cruddemo.DAOHibernateImpl;

import com.rest.springboot.cruddemo.DAO.TechnologyDao;
import com.rest.springboot.cruddemo.Entity.Technology;
import com.rest.springboot.cruddemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TechnologyDaoJpaImpl implements TechnologyDao {

    private EntityManager entityManager;

    @Autowired
    public TechnologyDaoJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Technology> findAll() {
        Query theQuery=entityManager.createQuery("from Technology");

        List<Technology> technologies=theQuery.getResultList();

        return technologies;
    }

    @Override
    public Technology findById(int theId) {
        Technology theTechnology=entityManager.find(Technology.class,theId);

        return theTechnology;
    }

    @Override
    public void save(Technology theTechnology) {
        Technology technology=entityManager.merge(theTechnology);

        theTechnology.setId(technology.getId());

    }

    @Override
    public void deleteById(int theId) {
        Query theQuery=entityManager.createQuery("delete from Technology where id=:technologyId");

        theQuery.setParameter("technologyId",theId);

        theQuery.executeUpdate();

    }
}
