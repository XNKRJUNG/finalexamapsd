package org.cyrus.finalexamapsd.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AstronautResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int experienceYears;

    private List<SatelliteResponseDto> satellites;
}
