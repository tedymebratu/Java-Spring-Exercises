package com.exercise.vAuto.ServiceImpl;

import com.exercise.vAuto.Dao.VehicleDao;
import com.exercise.vAuto.Model.Vehicle;
import com.exercise.vAuto.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleServiceImpl(VehicleDao theVehicleDao){
        vehicleDao=theVehicleDao;
    }
    @Override
    public Vehicle findById(int theId) {
        return vehicleDao.findById(theId);
    }

    @Override
    public void save(Vehicle theVehicle) {
        vehicleDao.save(theVehicle);
    }

    @Override
    public List<Vehicle> findAllVehicles(int theDealerId) {
        return vehicleDao.findAllVehicles(theDealerId);
    }
}
