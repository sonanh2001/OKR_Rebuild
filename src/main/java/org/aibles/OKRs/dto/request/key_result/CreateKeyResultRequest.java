package org.aibles.OKRs.dto.request.key_result;

import static org.aibles.OKRs.constants.CommonConstants.START_OF_PROGRESS;

import java.util.Optional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.aibles.OKRs.entity.KeyResult;
import org.aibles.OKRs.util.DateUtil;

@Data
public class CreateKeyResultRequest {

  @NotBlank(message = "title must not blank")
  private String title;

  @NotBlank(message = "step must not blank")
  private String step;

  private String mentor;

  private Float progress;
  @NotNull(message = "a key result must have start date")
  private Integer startDate;

  @NotNull(message = "a key result must have due date")
  private Integer dueDate;

  @NotNull(message = "a key result must have an objective id")
  private Long objectiveId;
  public KeyResult toKeyResult() {
    KeyResult keyResult = new KeyResult();
    keyResult.setTitle(this.getTitle());
    keyResult.setStep(this.getStep());
    keyResult.setMentor(this.getMentor());
    keyResult.setProgress(Optional.of(this.getProgress()).orElse(START_OF_PROGRESS));
    keyResult.setStartDate(DateUtil.convertIntegerToEpoch(this.getStartDate()));
    keyResult.setDueDate(DateUtil.convertIntegerToEpoch(this.getDueDate()));
    keyResult.setObjectiveId(this.getObjectiveId());
    return keyResult;
  }
}
