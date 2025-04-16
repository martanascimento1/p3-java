package com.c7.aeroporto.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_reservations")  // Adicionei nome explícito para a tabela
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private boolean checkedIn;
    private LocalDateTime reservationDate;
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    // Método estático para construção com lógica customizada
    public static Reservation createNewReservation(String passengerName, Flight flight) {
        return Reservation.builder()
                .passengerName(passengerName)
                .flight(flight)
                .reservationDate(LocalDateTime.now())
                .checkedIn(false)
                .build();
    }
}
