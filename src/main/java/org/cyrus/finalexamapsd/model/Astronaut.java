package org.cyrus.finalexamapsd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "astronauts")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int experienceYears;

    @ManyToMany
    @JoinTable(
            name = "astronaut_satellite",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private Set<Satellite> satellites = new HashSet<>();
}
