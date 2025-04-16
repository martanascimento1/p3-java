package com.c7.aeroporto.entities;

import com.c7.aeroporto.entities.vo.Address;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_airports") // Padronizado para plural
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> departingFlights = new ArrayList<>();

    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> arrivingFlights = new ArrayList<>();
}
