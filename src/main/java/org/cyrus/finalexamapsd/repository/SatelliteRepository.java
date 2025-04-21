package org.cyrus.finalexamapsd.repository;

import org.cyrus.finalexamapsd.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    Optional<Satellite> findByName(String name);
}
