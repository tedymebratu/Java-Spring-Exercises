package com.exercise.vAuto.RestController;

import com.exercise.vAuto.Model.Dataset;
import com.exercise.vAuto.Model.Dealer;
import com.exercise.vAuto.Model.Vehicle;
import com.exercise.vAuto.Service.DatasetService;
import com.exercise.vAuto.Service.DealerService;
import com.exercise.vAuto.Service.VehicleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    private DatasetService datasetService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    private VehicleService vehicleService;

    //Create Dataset    --  //,produces = { "application/json" }
    @PostMapping(value = "/dataset/{datasetId}")
    public Dataset createDataset(@PathVariable String datasetId){
        Dataset theDataset=datasetService.findById(datasetId);

        if(theDataset != null){
            throw new RuntimeException("Dataset Id exists: "+datasetId);
        }

        datasetService.save(datasetId);
        Dataset dataset=datasetService.findById(datasetId);
        return dataset;
    }

    //List datasets
    @GetMapping("/listdatasets")
    public List<Dataset> listDataset(){
      List<Dataset> datasets=datasetService.findAll();
      return datasets;
    }

    //Get dataset by datasetId
    @GetMapping("/{datasetId}")
    public Dataset getDataset(@PathVariable String datasetId){
        Dataset dataset=datasetService.findById(datasetId);

        return dataset;

    }

    //Get dataset by datasetId
    @GetMapping("/answer")
    public List<Vehicle> getAnswers(@ModelAttribute("vehicles") List<Vehicle> vehicles){
        List<Vehicle> theVehicles=vehicles;


       return theVehicles;
    }

    //Get dataset by datasetId  -- RequestEntity<?>
    @GetMapping("/{datasetId}/answer")
    public ResponseEntity<List<Vehicle>> getDealersByDataset(@PathVariable String datasetId){

        Date date = new Date();
        long startTime = date.getTime();
        //Dataset dataset=datasetService.findById(datasetId);
        List<Dealer> dealers=dealerService.findAllDealers(datasetId);
       // List<Vehicle> vehicles=vehicleService.findAllVehicles(datasetId);
        List<Vehicle> vehicles = new ArrayList<>();

        for (Dealer dealer : dealers) {
            vehicles.addAll(vehicleService.findAllVehicles(dealer.getId()));
        }


        date = new Date();
        long endTime = date.getTime();

        Long elapsedTime = endTime - startTime;

        System.out.println("The elaped time is " +(endTime - startTime) + " milli seconds!");

        ResponseEntity<List<Vehicle>> responseEntity = ResponseEntity.ok()
                .header("message", elapsedTime.toString())
                .body(vehicles);

        return responseEntity;

        //return vehicles;
    }



    //Get a dealer in a dataset
    @GetMapping("/{datasetId}/dealers/{dealerId}")
    public Dealer getDealerFromADataset(@PathVariable String datasetId, @PathVariable int dealerId){
        List<Dealer> dealers=dealerService.findAllDealers(datasetId);
        Dealer theDealer=null;

        for(Dealer dealer: dealers){
            if(dealer.getId() == dealerId){
                theDealer=dealer;
                break;
            }
        }


        if(theDealer == null) {
            throw new RuntimeException("Dealer Id or Dataset Id not found ");
        }

        return theDealer;
    }

    //Get vehicles in a dataset
    @GetMapping("/{datasetId}/vehicles")
    public List<Vehicle> getVehiclesByDataset(@PathVariable String datasetId){
        List<Dealer> dealers=dealerService.findAllDealers(datasetId);

        List<Vehicle> vehicles = new ArrayList<>();

        for (Dealer dealer : dealers) {
            vehicles.addAll(vehicleService.findAllVehicles(dealer.getId()));
        }

        if(vehicles == null) {
            throw new RuntimeException("Dataset Id not found "+datasetId);
        }

        return vehicles;
    }

    //Get a vehicle in a dataset
    @GetMapping("/{datasetId}/vehicles/{vehicleId}")
    public Vehicle getVehicleByDataset(@PathVariable String datasetId, @PathVariable int vehicleId) {
        List<Dealer> dealers=dealerService.findAllDealers(datasetId);

        List<Vehicle> vehicles = new ArrayList<>();

        for (Dealer dealer : dealers) {
            vehicles.addAll(vehicleService.findAllVehicles(dealer.getId()));
        }

        Vehicle theVehicle=null;

        for(Vehicle vehicle: vehicles){
            if(vehicle.getId() == vehicleId){
                theVehicle=vehicle;
                break;
            }
        }

        if(theVehicle == null) {
            throw new RuntimeException("Vehicle Id or Dataset Id not found ");
        }
        return theVehicle;
    }


}
