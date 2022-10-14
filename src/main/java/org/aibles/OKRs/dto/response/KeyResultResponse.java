package org.aibles.OKRs.dto.response;

import lombok.Data;
import org.aibles.OKRs.entity.KeyResult;
import org.aibles.OKRs.util.DateUtil;

@Data
public class KeyResultResponse {
  private long keyResultId;
  private String title;
  private String step;
  private String mentor;
  private float progress;
  private int startDate;
  private int dueDate;
  private long objectiveId;

  public static KeyResultResponse from(KeyResult keyResult) {
    KeyResultResponse response = new KeyResultResponse();
    response.setKeyResultId(keyResult.getKeyResultId());
    response.setTitle(keyResult.getTitle());
    response.setStep(keyResult.getStep());
    response.setMentor(keyResult.getMentor());
    response.setProgress(keyResult.getProgress());
    response.setStartDate(DateUtil.convertEpochToInteger(keyResult.getStartDate()));
    response.setDueDate(DateUtil.convertEpochToInteger(keyResult.getDueDate()));
    response.setObjectiveId(keyResult.getObjectiveId());
    return response;
  }
}
