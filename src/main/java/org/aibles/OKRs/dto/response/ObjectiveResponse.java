package org.aibles.OKRs.dto.response;

import lombok.Data;
import org.aibles.OKRs.entity.Objective;
import org.aibles.OKRs.util.DateUtil;

@Data
public class ObjectiveResponse {
  private long objectiveId;

  private String title;

  private String mentor;

  private String type;

  private String reason;

  private int startDate;

  private int dueDate;

  public static ObjectiveResponse from(Objective objective) {
    ObjectiveResponse response = new ObjectiveResponse();
    response.setObjectiveId(objective.getObjectiveId());
    response.setTitle(objective.getTitle());
    response.setMentor(objective.getMentor());
    response.setReason(objective.getReason());
    response.setType(objective.getType());
    response.setStartDate(DateUtil.convertEpochToInteger(objective.getStartDate()));
    response.setDueDate(DateUtil.convertEpochToInteger(objective.getDueDate()));
    return response;
  }
}
