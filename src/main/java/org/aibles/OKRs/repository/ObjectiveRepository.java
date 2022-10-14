package org.aibles.OKRs.repository;

import java.util.Optional;
import org.aibles.OKRs.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
  Boolean existsByTitle(String title);
  @Query("select o.startDate from Objective o where o.objectiveId = :id")
  Optional<Long> getStartDateById(@Param("id")long id);

  @Query("select o.dueDate from Objective o where o.objectiveId = :id")
  Optional<Long> getDueDateById(@Param("id")long id);
}
