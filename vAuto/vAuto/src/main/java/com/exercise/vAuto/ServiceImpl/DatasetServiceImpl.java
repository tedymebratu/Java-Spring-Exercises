package com.exercise.vAuto.ServiceImpl;

import com.exercise.vAuto.Dao.DatasetDao;
import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;
import com.exercise.vAuto.Service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    private DatasetDao datasetDao;

    @Autowired
    public DatasetServiceImpl(DatasetDao theDatasetDao){
        datasetDao=theDatasetDao;
    }
    @Override
    public Dataset findById(String theId) {
        return datasetDao.findById(theId);
    }

    @Override
    public Dealer findDealerById(String datasetId, int dealerId) {
        return datasetDao.findDealerById(datasetId,dealerId);
    }

    @Override
    public List<Vehicle> findVehiclesById(String theDatasetId) {
        return datasetDao.findVehiclesById(theDatasetId);
    }

    @Override
    public Vehicle findVehicleById(String theDatasetId, int theVehicleId) {
        return datasetDao.findVehicleById(theDatasetId,theVehicleId);
    }

    @Override
    public void save(String datasetId) {

        Dataset dataset = new Dataset(datasetId);
        datasetDao.save(dataset);
    }

    @Override
    public List<Dataset> findAll() {
        return datasetDao.findAll();
    }
}
