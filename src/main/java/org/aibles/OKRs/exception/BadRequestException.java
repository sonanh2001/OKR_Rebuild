package org.aibles.OKRs.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {

  public BadRequestException() {
    super();
    setCode("org.aibles.OKRs.exception.BadRequestException");
    setStatus(HttpStatus.BAD_REQUEST.value());
  }
}
