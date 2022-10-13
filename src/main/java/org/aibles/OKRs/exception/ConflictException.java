package org.aibles.OKRs.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {

  public ConflictException() {
    setStatus(HttpStatus.CONFLICT.value());
    setCode("org.aibles.OKRs.exception.ConflictException");
  }
}
