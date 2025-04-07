package com.c7.aeroporto.dtos;
import java.time.LocalDateTime;

public class ReservationResponseDTO {
    private Long id;
    private String passengerName;
    private boolean checkedIn;
    private LocalDateTime reservationDate;
    private Long flightId;
    private String destinationCity;

    public ReservationResponseDTO() {}

    public ReservationResponseDTO(Long id, String passengerName, boolean checkedIn, LocalDateTime reservationDate, Long flightId, String destinationCity) {
        this.id = id;
        this.passengerName = passengerName;
        this.checkedIn = checkedIn;
        this.reservationDate = reservationDate;
        this.flightId = flightId;
        this.destinationCity = destinationCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
}
