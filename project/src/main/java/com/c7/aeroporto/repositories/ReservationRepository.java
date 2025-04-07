package com.c7.aeroporto.repositories;

import com.c7.aeroporto.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

