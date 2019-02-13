package com.exercise.vAuto.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dataset")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dataset {
    @Id
    //@Column (name = "dataset_id")
    private String datasetId;

    /*@OneToMany (cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "dataset_id", nullable = false)
    @JsonIgnoreProperties("dataset")
    private List<Dealer> dealers=new ArrayList<>();*/


    public Dataset() {
    }

    public Dataset(String datasetId) {
        this.datasetId = datasetId;
    }

    /*@PrePersist
    private void ensureId(){
        this.setDatasetId(UUID.randomUUID().toString());
    }*/


    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

   /* public List<Dealer> getDealers() {
        return dealers;
    }

    public void addDealer(Dealer dealer) {
        dealers.add(dealer);
        //dealer.setDataset(this);
    }*/

   /* public void removeDealer(Dealer dealer){
        dealers.remove(dealer);
        //dealer.setDataset(null);
    }*/

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetId='" + datasetId + '\'' +
                //", dealers=" + dealers +
                '}';
    }
}
