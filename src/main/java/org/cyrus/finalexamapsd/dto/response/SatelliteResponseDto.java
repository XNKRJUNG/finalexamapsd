package org.cyrus.finalexamapsd.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SatelliteResponseDto {

    private Long id;
    private String name;
    private LocalDate launchDate;
    private String orbitType;
    private boolean decommissioned;
}
