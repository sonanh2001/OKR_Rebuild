package org.aibles.OKRs.exception;

import static org.aibles.OKRs.constants.CommonConstants.FIELD_KEY;
import static org.aibles.OKRs.constants.CommonConstants.TYPE_KEY;
import static org.aibles.OKRs.constants.CommonConstants.VALUE_KEY;

public class ExistedException extends BadRequestException {

  public ExistedException(String field, Object value, String type) {
    setCode("org.aibles.OKRs.exception.ExistedException");
    addParams(FIELD_KEY, field);
    addParams(VALUE_KEY, value);
    addParams(TYPE_KEY, type);
  }
}
