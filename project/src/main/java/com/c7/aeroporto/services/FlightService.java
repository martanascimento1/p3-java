package com.c7.aeroporto.services;

import com.c7.aeroporto.dtos.BaggageInfoDTO;
import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Plane;
import com.c7.aeroporto.entities.Reservation;
import com.c7.aeroporto.repositories.FlightRepository;
import com.c7.aeroporto.repositories.PlaneRepository;
import com.c7.aeroporto.repositories.ReservationRepository;
import com.c7.aeroporto.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Flight findByPlaneName(String planeName) {
        return flightRepository.findByPlaneName(planeName).orElseThrow(() -> new ResourceNotFoundException(planeName));
    }

    public List<Flight> findByDestinationCity(String city) {
        return flightRepository.findByDestinationCity(city).orElseThrow(() -> new ResourceNotFoundException(city));
    }

    public BaggageInfoDTO baggageInfo(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new ResourceNotFoundException(flightId));
        return new BaggageInfoDTO(
                flight,
                flight.getOverweightBaggageFee(),
                flight.getPlane().getMaxLuggageWeight(),
                flight.getPlane().getMaxWeightPerLuggage()
        );
    }


    public List<String> getAvailableSeats(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Voo não encontrado"));

        List<Reservation> reservations = reservationRepository.findByFlightId(flightId);
        Set<String> reservedSeats = reservations.stream()
                .map(Reservation::getSeatNumber)
                .collect(Collectors.toSet());

        List<String> allSeats = generateSeats(flight.getPlane());  // Passando o avião para gerar assentos dinâmicos
        return allSeats.stream()
                .filter(seat -> !reservedSeats.contains(seat))
                .collect(Collectors.toList());
    }

    private List<String> generateSeats(Plane plane) {
        List<String> seats = new ArrayList<>();
        for (int i = 1; i <= plane.getMaxPassengers(); i++) {  // Usa a capacidade real do avião
            seats.add("A" + i);
        }
        return seats;
    }
}
