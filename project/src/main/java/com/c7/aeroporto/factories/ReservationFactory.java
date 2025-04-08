package com.c7.aeroporto.factories;

import com.c7.aeroporto.dtos.ReservationRequestDTO;
import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Reservation;

public class ReservationFactory {

    public static Reservation createFromDTO(ReservationRequestDTO dto, Flight flight) {
        Reservation reservation = new Reservation();
        reservation.setPassengerName(dto.getPassengerName());
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);
        reservation.setReservationDate(java.time.LocalDateTime.now());
        return reservation;
    }
}

