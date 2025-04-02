package com.c7.aeroporto.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_planes")
public class Plane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    // CONSIDERAR O ACTUAL FLIGHT, O ULTIMO INSERIDO NA LISTA
    @OneToMany
    private List<Flight> flights = new ArrayList<>();

    private Integer maxPassengers;
    private Double maxLuggageWeight;
    private Double maxWeightPerLuggage;
    private Double maxWeightPerPassenger;
    private Double totalAllowedPassengerWeight;

    public Plane() {
    }

    public Plane(Long id, String name, String model, Integer maxPassengers, Double maxLuggageWeight, Double maxWeightPerLuggage, Double maxWeightPerPassenger, Double totalAllowedPassengerWeight) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.maxPassengers = maxPassengers;
        this.maxLuggageWeight = maxLuggageWeight;
        this.maxWeightPerLuggage = maxWeightPerLuggage;
        this.maxWeightPerPassenger = maxWeightPerPassenger;
        this.totalAllowedPassengerWeight = totalAllowedPassengerWeight;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public Double getMaxLuggageWeight() {
        return maxLuggageWeight;
    }

    public void setMaxLuggageWeight(Double maxLuggageWeight) {
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public Double getMaxWeightPerLuggage() {
        return maxWeightPerLuggage;
    }

    public void setMaxWeightPerLuggage(Double maxWeightPerLuggage) {
        this.maxWeightPerLuggage = maxWeightPerLuggage;
    }

    public Double getMaxWeightPerPassenger() {
        return maxWeightPerPassenger;
    }

    public void setMaxWeightPerPassenger(Double maxWeightPerPassenger) {
        this.maxWeightPerPassenger = maxWeightPerPassenger;
    }

    public Double getTotalAllowedPassengerWeight() {
        return totalAllowedPassengerWeight;
    }

    public void setTotalAllowedPassengerWeight(Double totalAllowedPassengerWeight) {
        this.totalAllowedPassengerWeight = totalAllowedPassengerWeight;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxPassengers=" + maxPassengers +
                ", maxLuggageWeight=" + maxLuggageWeight +
                ", maxWeightPerLuggage=" + maxWeightPerLuggage +
                ", maxWeightPerPassenger=" + maxWeightPerPassenger +
                ", totalAllowedPassengerWeight=" + totalAllowedPassengerWeight +
                '}';
    }

}