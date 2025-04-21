package org.cyrus.finalexamapsd.mapper;

import org.cyrus.finalexamapsd.dto.request.SatelliteRequestDto;
import org.cyrus.finalexamapsd.dto.response.SatelliteResponseDto;
import org.cyrus.finalexamapsd.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AstronautMapper.class})
public interface SatelliteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "astronauts", ignore = true) // we don't populate this in response
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);

    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);

    List<SatelliteResponseDto> satelllitesToSatelliteResponseDtoList(List<Satellite> satellites);
}
