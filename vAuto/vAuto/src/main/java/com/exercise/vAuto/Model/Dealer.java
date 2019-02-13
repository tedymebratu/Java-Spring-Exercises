package com.exercise.vAuto.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dealer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    /*@OneToMany (cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", nullable = false)
    @JsonIgnoreProperties("dealer")
    private List<Vehicle> vehicles=new ArrayList<>();*/

    @ManyToOne (cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "datasetId", nullable = false)
    //@JsonIgnoreProperties("dataset")
    //@Column(name = "datasetId")
    private Dataset dataset;



    public Dealer() {
    }

    public Dealer(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        //vehicle.setDealer(this);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
        //vehicle.setDealer(null);
    }*/

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", vehicles=" + vehicles +
                ", dataset=" + dataset +
                '}';
    }
}
