package com.exercise.vAuto.RestController;

import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Service.DatasetService;
import com.exercise.vAuto.Service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DealerRestController {

    @Autowired
    private DealerService dealerService;
    @Autowired
    private DatasetService datasetService;

    //Create dealer
    @PostMapping("/dealer/{datasetId}")
    public Dealer createDealer(@RequestBody Dealer theDealer,@PathVariable String datasetId){
        Dataset dataset=datasetService.findById(datasetId);
        theDealer.setDataset(dataset);
        dealerService.save(theDealer);

        return theDealer;
    }
}
