package org.cyrus.finalexamapsd.service.impl;

import lombok.RequiredArgsConstructor;
import org.cyrus.finalexamapsd.dto.request.SatelliteRequestDto;
import org.cyrus.finalexamapsd.dto.response.SatelliteResponseDto;

import org.cyrus.finalexamapsd.exception.satellite.SatelliteNotFoundException;
import org.cyrus.finalexamapsd.model.Satellite;
import org.cyrus.finalexamapsd.repository.SatelliteRepository;
import org.cyrus.finalexamapsd.mapper.SatelliteMapper;
import org.cyrus.finalexamapsd.service.SatelliteService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepo;
    private final SatelliteMapper satelliteMapper;

    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto) {
        Satellite existing = satelliteRepo.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));

        if (existing.isDecommissioned()) {
            throw new IllegalStateException("Cannot update a decommissioned satellite");
        }

        // Manual update
        existing.setName(dto.getName());
        existing.setLaunchDate(dto.getLaunchDate());
        existing.setOrbitType(dto.getOrbitType());
        existing.setDecommissioned(dto.getDecommissioned());

        Satellite updated = satelliteRepo.save(existing);
        return satelliteMapper.satelliteToSatelliteResponseDto(updated);
    }
}
