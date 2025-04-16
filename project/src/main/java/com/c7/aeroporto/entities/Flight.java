package com.c7.aeroporto.entities;

import com.c7.aeroporto.entities.vo.Address;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_flights")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    private Double flightPrice;
    private Double overweightBaggageFee;

    @ManyToOne
    @JoinColumn(name = "origin_airport_id")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id")
    private Airport destinationAirport;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "origin_street")),
            @AttributeOverride(name = "number", column = @Column(name = "origin_number")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "origin_zip_code")),
            @AttributeOverride(name = "city", column = @Column(name = "origin_city")),
            @AttributeOverride(name = "state", column = @Column(name = "origin_state"))
    })
    private Address origin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "destination_street")),
            @AttributeOverride(name = "number", column = @Column(name = "destination_number")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "destination_zip_code")),
            @AttributeOverride(name = "city", column = @Column(name = "destination_city")),
            @AttributeOverride(name = "state", column = @Column(name = "destination_state"))
    })
    private Address destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}