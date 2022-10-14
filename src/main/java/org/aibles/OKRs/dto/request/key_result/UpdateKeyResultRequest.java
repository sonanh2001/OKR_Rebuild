package org.aibles.OKRs.dto.request.key_result;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aibles.OKRs.entity.KeyResult;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateKeyResultRequest extends CreateKeyResultRequest {
  @NotNull(message = "a updated key result must have an id")
  private Long keyResultId;

  public KeyResult toKeyResult(KeyResult keyResult) {
    KeyResult keyResultUpdated = super.toKeyResult();
    keyResultUpdated.setKeyResultId(keyResult.getKeyResultId());
    keyResultUpdated.setCreatedAt(keyResult.getCreatedAt());
    keyResultUpdated.setUpdatedAt(keyResult.getUpdatedAt());
    return keyResultUpdated;
  }
}
