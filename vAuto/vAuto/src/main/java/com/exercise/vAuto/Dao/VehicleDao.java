package com.exercise.vAuto.Dao;

import com.exercise.vAuto.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao {
    public Vehicle findById(int theId);
    public void save(Vehicle theVehicle);
    public List<Vehicle> findAllVehicles(int theDealerId);
}
