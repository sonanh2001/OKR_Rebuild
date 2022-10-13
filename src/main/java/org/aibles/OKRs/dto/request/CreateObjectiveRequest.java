package org.aibles.OKRs.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.aibles.OKRs.entity.Objective;
import org.aibles.OKRs.util.DateUtil;

@Data
public class CreateObjectiveRequest {
  @NotBlank(message = "title must not blank")
  private String title;

  @NotBlank(message = "mentor must not blank")
  private String mentor;

  private String type;

  @NotBlank(message = "reason must not blank")
  private String reason;

  @NotNull(message = "an objective must have start date")
  private Integer startDate;

  @NotNull(message = "an objective must have due date")
  private Integer dueDate;

  public Objective toObjective() {
    Objective objective = new Objective();
    objective.setTitle(this.getTitle());
    objective.setMentor(this.getMentor());
    objective.setReason(this.getReason());
    objective.setType(this.getType());
    objective.setStartDate(DateUtil.convertIntegerToEpoch(this.getStartDate()));
    objective.setDueDate(DateUtil.convertIntegerToEpoch(this.getDueDate()));
    return objective;
  }
}
