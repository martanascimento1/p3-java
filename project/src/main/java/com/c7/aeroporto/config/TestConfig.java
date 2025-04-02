package com.c7.aeroporto.config;

import com.c7.aeroporto.entities.Flight;
import com.c7.aeroporto.entities.Plane;
import com.c7.aeroporto.entities.vo.Address;
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

    @Override
    public void run(String... args) throws Exception{

        Plane p1 = new Plane(null ,"Aviator", "Boeing 752", 100, 10000.0, 100.20, 150.0, 100000.5);

        planeRepository.save(p1);

        Address a1 = new Address("Fix Ders", 20, 5210, "Los Angeles", "California");
        Address a2 = new Address("Holes Drude", 32, 1230, "Las Vegas", "Nevada");

        Flight f1 = new Flight(null, 1, p1, 1020.0, 5.5, a1, a2, LocalDateTime.of(2025, 03, 20, 14, 30), LocalDateTime.of(2025, 03, 20, 15, 30));

        Flight f2 = new Flight(null, 1, p1, 1020.0, 5.5, a1, a2, LocalDateTime.of(2025, 03, 20, 14, 30), LocalDateTime.of(2025, 03, 20, 15, 30));

        flightRepository.save(f1);
        flightRepository.save(f2);


    }

}
