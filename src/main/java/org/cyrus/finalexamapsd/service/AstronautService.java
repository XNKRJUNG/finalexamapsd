package org.cyrus.finalexamapsd.service;

import org.cyrus.finalexamapsd.dto.request.AstronautRequestDto;
import org.cyrus.finalexamapsd.dto.response.AstronautResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto dto);
    Page<AstronautResponseDto> getAllAstronauts(Pageable pageable);
}
