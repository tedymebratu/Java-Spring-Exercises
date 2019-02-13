package com.exercise.vAuto.Service;

import com.exercise.vAuto.Dao.DatasetDao;
import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;

import java.util.List;

public interface DatasetService {
    public Dataset findById(String theId);
    public Dealer findDealerById(String datasetId, int dealerId);
    public List<Vehicle> findVehiclesById(String theDatasetId);
    public Vehicle findVehicleById(String theDatasetId, int theVehicleId);
    public void save(String datasetId);
    public List<Dataset> findAll();
}
