package com.c7.aeroporto.config;
import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Plane;
import com.c7.aeroporto.entities.Airport;
import com.c7.aeroporto.entities.vo.Address;
import com.c7.aeroporto.repositories.AirportRepository;
import com.c7.aeroporto.repositories.FlightRepository;
import com.c7.aeroporto.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private  AirportRepository airportRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criar Address
        Address origin = Address.builder()
                .street("Main St")
                .number(100)
                .zipCode(12345)
                .city("São Paulo")
                .state("SP")
                .build();

        Address destination = Address.builder()
                .street("Second Ave")
                .number(200)
                .zipCode(54321)
                .city("Rio de Janeiro")
                .state("RJ")
                .build();

        // Criar Plane
        Plane plane = Plane.builder()
                .name("Airbus A320")
                .model("A320")
                .maxPassengers(150)
                .maxLuggageWeight(20000.0)
                .maxWeightPerLuggage(23.0)
                .maxWeightPerPassenger(100.0)
                .totalAllowedPassengerWeight(15000.0)
                .build();

        planeRepository.save(plane);

        // Criar Flight
        Flight flight = Flight.builder()
                .status(1)
                .plane(plane)
                .flightPrice(1200.0)
                .overweightBaggageFee(10.5)
                .origin(origin)
                .destination(destination)
                .departureTime(LocalDateTime.now())
                .arrivalTime(LocalDateTime.now().plusHours(2))
                .build();

        flightRepository.save(flight);
    }
}