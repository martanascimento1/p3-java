package com.c7.aeroporto.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private boolean checkedIn;

    private LocalDateTime reservationDate;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Reservation() {}

    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
        this.reservationDate = LocalDateTime.now();
        this.checkedIn = false;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
