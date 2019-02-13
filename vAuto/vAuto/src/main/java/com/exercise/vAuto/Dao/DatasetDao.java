package com.exercise.vAuto.Dao;

import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Set;

public interface DatasetDao {
    public Dataset findById(String theId);
    public Dealer findDealerById(String theDatasetId, int theDealerId);
    public List<Vehicle> findVehiclesById(String theDatasetId);
    public Vehicle findVehicleById(String theDatasetId, int theVehicleId);
    public void save(Dataset theDataset);
    public List<Dataset> findAll();



}
