package com.exercise.vAuto.Service;

import com.exercise.vAuto.Dao.DealerDao;
import com.exercise.vAuto.Model.Dealer;

import java.util.List;

public interface DealerService {
    public Dealer findById(int theId);
    public void save(Dealer theDealer);
    public List<Dealer> findAllDealers(String theDatasetId);
}
