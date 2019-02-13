package com.exercise.vAuto.Dao;

import com.exercise.vAuto.Model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerDao {
    public Dealer findById(int theId);
    public void save(Dealer theDealer);
    public List<Dealer> findAllDealers(String theDatasetId);
}
