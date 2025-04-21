package org.cyrus.finalexamapsd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cyrus.finalexamapsd.dto.request.SatelliteRequestDto;
import org.cyrus.finalexamapsd.dto.response.SatelliteResponseDto;
import org.cyrus.finalexamapsd.service.SatelliteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto dto
    ) {
        SatelliteResponseDto updated = satelliteService.updateSatellite(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
