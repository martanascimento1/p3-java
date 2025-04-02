package com.c7.aeroporto.dtos;

import com.c7.aeroporto.entities.Flight;

public class BaggageInfoDTO {

    private Flight flight;
    private Double baggageFee;
    private Double maxLuggageWeight;
    private Double maxWeightPerLuggage;

    public BaggageInfoDTO(){}

    public BaggageInfoDTO(Flight flight, Double baggageFee, Double maxLuggageWeight, Double maxWeightPerLuggage){
        this.flight = flight;
        this.baggageFee = baggageFee;
        this.maxLuggageWeight = maxLuggageWeight;
        this.maxWeightPerLuggage = maxWeightPerLuggage;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public Double getBaggageFee() {
        return baggageFee;
    }

    public void setBaggageFee(Double baggageFee) {
        this.baggageFee = baggageFee;
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
}
