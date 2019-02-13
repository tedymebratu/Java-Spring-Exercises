package com.exercise.vAuto.Service;

import com.exercise.vAuto.Dao.VehicleDao;
import com.exercise.vAuto.Model.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle findById(int theId);
    public void save(Vehicle theVehicle);
    public List<Vehicle> findAllVehicles(int theDealerId);
}
