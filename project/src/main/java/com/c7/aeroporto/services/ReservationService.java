package com.c7.aeroporto.services;

import com.c7.aeroporto.dtos.ReservationRequestDTO;
import com.c7.aeroporto.dtos.ReservationResponseDTO;
import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Reservation;
import com.c7.aeroporto.repositories.FlightRepository;
import com.c7.aeroporto.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// O Spring já implementa o padrão singleton,  criando uma única instância de ReservationService e injeta essa instância em qualquer parte do código assinada com @Autowired
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

   @Autowired
    private FlightRepository flightRepository;

    public ReservationResponseDTO create(ReservationRequestDTO dto) {
        Optional<Flight> flightOpt = flightRepository.findById(dto.getFlightId());
        if (flightOpt.isEmpty()) {
            throw new RuntimeException("Voo não encontrado");
        }

        Reservation reservation = new Reservation();
        reservation.setPassengerName(dto.getPassengerName());
        reservation.setFlight(flightOpt.get());
        reservation.setCheckedIn(false);
        reservation.setReservationDate(LocalDateTime.now());

        Reservation saved = reservationRepository.save(reservation);

        return toDTO(saved);
    }

    public ReservationResponseDTO findById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return toDTO(reservation);
    }

    public ReservationResponseDTO toDTO(Reservation reservation) {
        return new ReservationResponseDTO(
                reservation.getId(),
                reservation.getPassengerName(),
                reservation.isCheckedIn(),
                reservation.getReservationDate(),
                reservation.getFlight().getId(),
                reservation.getFlight().getDestination().getCity()
         );
    }

    public List<ReservationResponseDTO> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(ReservationResponseDTO::new)
                .toList();
    }

    public ReservationResponseDTO changeSeat(Long reservationId, String newSeatNumber) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        boolean ocupado = reservationRepository.existsByFlightIdAndSeatNumber(reservation.getFlight().getId(), newSeatNumber);
        if (ocupado) {
            throw new RuntimeException("Assento já está ocupado.");
        }

        reservation.setSeatNumber(newSeatNumber);
        reservationRepository.save(reservation);
        return new ReservationResponseDTO(reservation);
    }


}





