package org.cyrus.finalexamapsd.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class AstronautRequestDto {

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Min(0)
    @Max(50)
    private int experienceYears;

    @NotNull
    private List<@NotNull Long> satelliteIds; // must not be null, and contain valid IDs
}
