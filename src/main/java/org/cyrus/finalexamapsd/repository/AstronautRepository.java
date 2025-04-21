package org.cyrus.finalexamapsd.repository;

import org.cyrus.finalexamapsd.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
