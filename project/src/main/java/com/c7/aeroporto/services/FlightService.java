package com.c7.aeroporto.services;
import com.c7.aeroporto.dtos.BaggageInfoDTO;
import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Reservation;
import com.c7.aeroporto.repositories.FlightRepository;
import com.c7.aeroporto.repositories.PlaneRepository;
import com.c7.aeroporto.repositories.ReservationRepository;
import com.c7.aeroporto.services.exceptions.ResourceNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebResourcesRuntimeHints;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
    private ReservationRepository reservationRepository;

    // GET Methods

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight findById(Long id){
        return flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public Flight findByPlaneName(String planeName) {

        return flightRepository.findByPlaneName(planeName).orElseThrow(() -> new ResourceNotFoundException(planeName));
    }

    public List<Flight> findByDestinationCity(String city){
        return flightRepository.findByDestinationCity(city).orElseThrow(() -> new ResourceNotFoundException(city));
    }

    public BaggageInfoDTO baggageInfo(Long flightId){

        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new ResourceNotFoundException(flightId));

        BaggageInfoDTO baggageInfoDTO = new BaggageInfoDTO(flight, flight.getOverweightBaggageFee(), flight.getPlane().getMaxLuggageWeight(), flight.getPlane().getMaxWeightPerLuggage());

        return baggageInfoDTO;

    }

    public List<String> getAvailableSeats(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Voo não encontrado"));

        List<Reservation> reservations = reservationRepository.findByFlightId(flightId);
        Set<String> reservedSeats = reservations.stream()
                .map(Reservation::getSeatNumber)
                .collect(Collectors.toSet());

        // Suponha que o avião tenha 30 assentos: A1 a A30
        List<String> allSeats = generateSeats(); // Função abaixo
        return allSeats.stream()
                .filter(seat -> !reservedSeats.contains(seat))
                .collect(Collectors.toList());
    }

    private List<String> generateSeats() {
        List<String> seats = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            seats.add("A" + i);
        }
        return seats;
    }


}
