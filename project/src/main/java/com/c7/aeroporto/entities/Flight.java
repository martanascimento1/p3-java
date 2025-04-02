package com.c7.aeroporto.entities;

import com.c7.aeroporto.entities.vo.Address;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 1 - PARTIDA EM BREVE, 2 - PARTINDO, 3 - NO AR, 4 - CHEGANDO, 5 - NO LOCAL FINAL
    private Integer status;

    @ManyToOne
    private Plane plane;
    private Double flightPrice;
    private Double overweightBaggageFee;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "origin_street")),
            @AttributeOverride(name = "number", column = @Column(name = "origin_number")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "origin_zip_code")),
            @AttributeOverride(name = "city", column = @Column(name = "origin_city")),
            @AttributeOverride(name = "state", column = @Column(name = "origin_state"))
    })
    private Address origin;

    @ManyToOne
    private Airport originAirport;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "destination_street")),
            @AttributeOverride(name = "number", column = @Column(name = "destination_number")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "destination_zip_code")),
            @AttributeOverride(name = "city", column = @Column(name = "destination_city")),
            @AttributeOverride(name = "state", column = @Column(name = "destination_state"))
    })
    private Address destination;
    @ManyToOne
    private Airport destinationAirport;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(){}
    public Flight(Long id, Integer status, Plane plane, Double flightPrice, Double overweightBaggageFee, Address origin, Address destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.status = status;
        this.plane = plane;
        this.flightPrice = flightPrice;
        this.overweightBaggageFee = overweightBaggageFee;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }


    public Double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Double getOverweightBaggageFee() {
        return overweightBaggageFee;
    }

    public void setOverweightBaggageFee(Double overweightBaggageFee) {
        this.overweightBaggageFee = overweightBaggageFee;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
