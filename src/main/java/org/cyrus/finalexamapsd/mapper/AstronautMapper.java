package org.cyrus.finalexamapsd.mapper;

import org.cyrus.finalexamapsd.dto.request.AstronautRequestDto;
import org.cyrus.finalexamapsd.dto.response.AstronautResponseDto;
import org.cyrus.finalexamapsd.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SatelliteMapper.class})
public interface AstronautMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "satellites", ignore = true) // set in service after satellite lookup
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);

    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);

    List<AstronautResponseDto> astronautsToAstronautResponseDtoList(List<Astronaut> astronauts);
}
