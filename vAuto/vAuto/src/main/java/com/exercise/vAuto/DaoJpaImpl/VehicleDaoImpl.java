package com.exercise.vAuto.DaoJpaImpl;

import com.exercise.vAuto.Dao.VehicleDao;
import com.exercise.vAuto.Model.Vehicle;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    private EntityManager entityManager;

    @Autowired
    public VehicleDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public Vehicle findById(int theId) {
        Session session=entityManager.unwrap(Session.class);

        Vehicle vehicle=session.get(Vehicle.class,theId);
        return vehicle;
    }

    @Override
    public void save(Vehicle theVehicle) {
        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theVehicle);
    }

    @Override
    public List<Vehicle> findAllVehicles(int theDealerId) {
        Session session=entityManager.unwrap(Session.class);
        Query theQuery=entityManager.createQuery("FROM Vehicle v WHERE v.dealer.id =:dealerId");

        theQuery.setParameter("dealerId",theDealerId);
        List<Vehicle> vehicles=theQuery.getResultList();
        return vehicles;
    }
}
