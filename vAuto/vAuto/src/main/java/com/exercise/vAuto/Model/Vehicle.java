package com.exercise.vAuto.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private int year;
    private String make;
    private String model;

    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "dealerId", nullable = false)
    //@JsonIgnoreProperties("dealer")
    //@Column(name = "dealerId")
    private Dealer dealer;


    public Vehicle() {
    }

    public Vehicle(int year, String make, String model, Dealer dealer) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.dealer = dealer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", dealer=" + dealer +
                '}';
    }
}
