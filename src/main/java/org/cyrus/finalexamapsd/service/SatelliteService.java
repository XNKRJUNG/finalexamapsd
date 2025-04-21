package org.cyrus.finalexamapsd.service;

import org.cyrus.finalexamapsd.dto.request.SatelliteRequestDto;
import org.cyrus.finalexamapsd.dto.response.SatelliteResponseDto;

public interface SatelliteService {
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto);
}
