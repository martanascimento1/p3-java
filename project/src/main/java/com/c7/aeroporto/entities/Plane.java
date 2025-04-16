package com.c7.aeroporto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_planes")
public class Plane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    // CONSIDERAR O ACTUAL FLIGHT, O ULTIMO INSERIDO NA LISTA
    @Builder.Default
    @OneToMany
    private List<Flight> flights = new ArrayList<>();

    private Integer maxPassengers;
    private Double maxLuggageWeight;
    private Double maxWeightPerLuggage;
    private Double maxWeightPerPassenger;
    private Double totalAllowedPassengerWeight;

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxPassengers=" + maxPassengers +
                ", maxLuggageWeight=" + maxLuggageWeight +
                ", maxWeightPerLuggage=" + maxWeightPerLuggage +
                ", maxWeightPerPassenger=" + maxWeightPerPassenger +
                ", totalAllowedPassengerWeight=" + totalAllowedPassengerWeight +
                '}';
    }
}