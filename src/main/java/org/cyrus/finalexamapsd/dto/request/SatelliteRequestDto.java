package org.cyrus.finalexamapsd.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SatelliteRequestDto {

    @NotBlank
    private String name;

    @Past(message = "Launch date must be in the past")
    @NotNull
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;

    @NotNull
    private Boolean decommissioned;
}
