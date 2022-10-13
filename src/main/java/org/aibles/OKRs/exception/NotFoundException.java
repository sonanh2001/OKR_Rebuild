package org.aibles.OKRs.exception;

import static org.aibles.OKRs.constants.CommonConstants.FIELD_KEY;
import static org.aibles.OKRs.constants.CommonConstants.TYPE_KEY;
import static org.aibles.OKRs.constants.CommonConstants.VALUE_KEY;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

  public NotFoundException(String field, Object value, String type) {
    super();
    setStatus(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.OKRs.exception.NotFoundException");
    addParams(FIELD_KEY, field);
    addParams(VALUE_KEY, value);
    addParams(TYPE_KEY, type);
  }
}
