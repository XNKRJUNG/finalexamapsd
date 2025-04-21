package org.cyrus.finalexamapsd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "satellites")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate launchDate;

    @Column(nullable = false)
    private String orbitType;

    @Column(nullable = false)
    private boolean decommissioned;

    @ManyToMany(mappedBy = "satellites")
    private Set<Astronaut> astronauts = new HashSet<>();
}
