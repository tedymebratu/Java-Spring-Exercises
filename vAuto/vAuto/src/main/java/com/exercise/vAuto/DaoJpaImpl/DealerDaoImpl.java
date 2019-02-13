package com.exercise.vAuto.DaoJpaImpl;

import com.exercise.vAuto.Dao.DealerDao;
import com.exercise.vAuto.Model.Dealer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DealerDaoImpl implements DealerDao {

    private EntityManager entityManager;

    @Autowired
    public DealerDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public Dealer findById(int theId) {
        Session session=entityManager.unwrap(Session.class);

        Dealer dealer=session.get(Dealer.class,theId);
        return dealer;
    }

    @Override
    public void save(Dealer theDealer) {
        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theDealer);
    }

    @Override
    public List<Dealer> findAllDealers(String theDatasetId) {
        Session session=entityManager.unwrap(Session.class);
        Query theQuery=entityManager.createQuery("FROM Dealer d WHERE d.dataset.datasetId= :datasetId");

        theQuery.setParameter("datasetId",theDatasetId);
        List<Dealer> dealers=theQuery.getResultList();
        return dealers;
    }
}
