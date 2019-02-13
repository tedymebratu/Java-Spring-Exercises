package com.exercise.vAuto.ServiceImpl;

import com.exercise.vAuto.Dao.DealerDao;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerServiceImpl implements DealerService {

    private DealerDao dealerDao;

    @Autowired
    public DealerServiceImpl(DealerDao theDealerDao) {
        dealerDao=theDealerDao;
    }
    @Override
    public Dealer findById(int theId) {
        return dealerDao.findById(theId);
    }

    @Override
    public void save(Dealer theDealer) {
        dealerDao.save(theDealer);
    }

    @Override
    public List<Dealer> findAllDealers(String theDatasetId) {
        return dealerDao.findAllDealers(theDatasetId);
    }
}
