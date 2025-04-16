
package com.c7.aeroporto.repositories;

import com.c7.aeroporto.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}