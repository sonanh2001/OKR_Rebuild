package org.aibles.OKRs.dto.request.objective;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aibles.OKRs.dto.request.objective.CreateObjectiveRequest;
import org.aibles.OKRs.entity.Objective;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateObjectiveRequest extends CreateObjectiveRequest {
  @NotNull(message = "an update objective must have id")
  private Long objectiveId;

  public Objective toObjective(Objective objective) {
    Objective objectiveUpdated = super.toObjective();
    objectiveUpdated.setObjectiveId(objective.getObjectiveId());
    objectiveUpdated.setCreatedAt(objective.getCreatedAt());
    objectiveUpdated.setUpdatedAt(objective.getUpdatedAt());
    return objectiveUpdated;
  }
}
