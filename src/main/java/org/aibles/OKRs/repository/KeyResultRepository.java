package org.aibles.OKRs.repository;

import org.aibles.OKRs.entity.KeyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyResultRepository extends JpaRepository<KeyResult, Long> {
  Boolean existsByTitle(String title);
}
