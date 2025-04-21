package org.cyrus.finalexamapsd.service.impl;

import lombok.RequiredArgsConstructor;
import org.cyrus.finalexamapsd.dto.request.AstronautRequestDto;
import org.cyrus.finalexamapsd.dto.response.AstronautResponseDto;
import org.cyrus.finalexamapsd.mapper.AstronautMapper;
import org.cyrus.finalexamapsd.model.Astronaut;
import org.cyrus.finalexamapsd.model.Satellite;
import org.cyrus.finalexamapsd.repository.AstronautRepository;
import org.cyrus.finalexamapsd.repository.SatelliteRepository;
import org.cyrus.finalexamapsd.service.AstronautService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepo;
    private final SatelliteRepository satelliteRepo;
    private final AstronautMapper astronautMapper;

    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto dto) {
        Astronaut astronaut = astronautMapper.astronautRequestDtoToAstronaut(dto);

        List<Satellite> satellites = satelliteRepo.findAllById(dto.getSatelliteIds());
        if (satellites.size() != dto.getSatelliteIds().size()) {
            throw new org.cyrus.finalexamapsd.exception.satellite.SatelliteNotFoundException("One or more satellites not found");
        }

        astronaut.getSatellites().addAll(satellites);
        Astronaut saved = astronautRepo.save(astronaut);
        return astronautMapper.astronautToAstronautResponseDto(saved);
    }

    @Override
    public Page<AstronautResponseDto> getAllAstronauts(Pageable pageable) {
        return astronautRepo.findAll(pageable)
                .map(astronautMapper::astronautToAstronautResponseDto);
    }
}
