package com.rest.springboot.cruddemo.DAOHibernateImpl;

import com.rest.springboot.cruddemo.DAO.UserDao;
import com.rest.springboot.cruddemo.Entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session currentSession=entityManager.unwrap(Session.class);

        Query<User> theQuery=currentSession.createQuery("from User", User.class);

        List<User> users=theQuery.getResultList();

        return users;
    }

    @Override
    @Transactional
    public User findById(int theId) {
        Session currentSession=entityManager.unwrap(Session.class);

        User theUser=currentSession.get(User.class,theId);
        return theUser;
    }

    @Override
    @Transactional
    public void save(User theUser) {
        Session currentSession=entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUser);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession=entityManager.unwrap(Session.class);
        Query theQuery=currentSession.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId",theId);

        theQuery.executeUpdate();


    }

    @Override
    @Transactional
    public List<User> findAllByPage() {
        Session currentSession=entityManager.unwrap(Session.class);
        Query theQuery=currentSession.createQuery("from User");

        theQuery.setFirstResult(1);
        theQuery.setMaxResults(2);

        List<User> theUser=theQuery.list();
        return theUser;
    }

    @Override
    @Transactional
    public List<User> findByTechId(int theId) {
        Session currentSession=entityManager.unwrap(Session.class);

        Query<User> theQuery=currentSession.createQuery("select u from User u inner join fetch u.Technology t" +
                "where t.id =: technologyId", User.class);

        theQuery.setParameter("technologyId",theId);

        List<User> users=theQuery.getResultList();

        return users;
    }
}
