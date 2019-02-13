package com.exercise.vAuto.DaoJpaImpl;

import com.exercise.vAuto.Dao.DatasetDao;
import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class DatasetDaoImpl implements DatasetDao {

    private EntityManager entityManager;

    @Autowired
    public DatasetDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public Dataset findById(String theId) {
        Session session=entityManager.unwrap(Session.class);
        Dataset dataset=session.get(Dataset.class,theId);

        return dataset;
    }

    @Override
    @Transactional
    public Dealer findDealerById(String theDatasetId, int theDealerId) {
        Session session=entityManager.unwrap(Session.class);

        Query theQuery=entityManager.createQuery("select dl from Dataset dt join dt.dealers dl " +
                "where dl.id = :dealerId and dt.id = :datasetId");
        theQuery.setParameter("dealerId",theDealerId);
        theQuery.setParameter("datasetId",theDatasetId);
        Dealer dealer=(Dealer)theQuery.getSingleResult();

        return dealer;
    }

    @Override
    @Transactional
    public List<Vehicle> findVehiclesById(String thedatasetId) {
        Session session=entityManager.unwrap(Session.class);

        Query theQuery=entityManager.createQuery("select v from Dataset dt join dt.dealers dl join dl.vehicles v " +
                "where dt.id =: datasetId");

        theQuery.setParameter("datasetId",thedatasetId);
        List<Vehicle> vehicles=theQuery.getResultList();

        return vehicles;
    }

    @Override
    @Transactional
    public Vehicle findVehicleById(String theDatasetId, int theVehicleId) {
        Session session=entityManager.unwrap(Session.class);

        Query theQuery=entityManager.createQuery("select v from Dataset dt join dt.dealers dl join fetch dl.vehicles v" +
                "where v.id= :vehicleId and dt.id =: datasetId");

        theQuery.setParameter("vehicleId", theVehicleId);
        theQuery.setParameter("datasetId",theDatasetId);

        Vehicle vehicle=(Vehicle)theQuery.getSingleResult();


        return vehicle;
    }

    @Override
    public void save(Dataset theDataset) {
        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theDataset);
    }

    @Override
    public List<Dataset> findAll() {
        Session currentSession=entityManager.unwrap(Session.class);
        org.hibernate.query.Query<Dataset> theQuery=currentSession.createQuery("from Dataset", Dataset.class);

        List<Dataset> datasets=theQuery.getResultList();
        return datasets;
    }


}
