package com.exercise.vAuto.RestController;

import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;
import com.exercise.vAuto.Service.DatasetService;
import com.exercise.vAuto.Service.DealerService;
import com.exercise.vAuto.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VehicleRestController {

    @Autowired
    private DatasetService datasetService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    private VehicleService vehicleService;

    //Create Vehicle
    @PostMapping("/vehicle/{dealerId}")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle, @PathVariable int dealerId){
        Dealer dealer=dealerService.findById(dealerId);
        vehicle.setDealer(dealer);
        vehicleService.save(vehicle);
        return vehicle;
    }
}
