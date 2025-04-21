package org.cyrus.finalexamapsd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cyrus.finalexamapsd.dto.request.AstronautRequestDto;
import org.cyrus.finalexamapsd.dto.response.AstronautResponseDto;
import org.cyrus.finalexamapsd.service.AstronautService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AstronautResponseDto> createAstronaut(
            @Valid @RequestBody AstronautRequestDto dto
    ) {
        AstronautResponseDto created = astronautService.createAstronaut(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<Page<AstronautResponseDto>> getAllAstronauts(Pageable pageable) {
        Page<AstronautResponseDto> page = astronautService.getAllAstronauts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }
}
