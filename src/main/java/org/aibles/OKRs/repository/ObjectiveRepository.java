package org.aibles.OKRs.repository;

import org.aibles.OKRs.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
  Boolean existsByTitle(String title);
}
