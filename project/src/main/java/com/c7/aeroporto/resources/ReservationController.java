package com.c7.aeroporto.resources;
import com.c7.aeroporto.dtos.ReservationRequestDTO;
import com.c7.aeroporto.dtos.ReservationResponseDTO;
import com.c7.aeroporto.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations") // <- ESSA LINHA É FUNDAMENTAL!
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO dto) {
        ReservationResponseDTO response = reservationService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservation(@PathVariable Long id) {
        ReservationResponseDTO response = reservationService.findById(id);
        return ResponseEntity.ok(response);
    }

    // (Outros métodos: cancelamento, modificação etc. podem vir depois)
}

