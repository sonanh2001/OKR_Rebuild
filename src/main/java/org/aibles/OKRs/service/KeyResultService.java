package org.aibles.OKRs.service;

import org.aibles.OKRs.dto.request.key_result.CreateKeyResultRequest;
import org.aibles.OKRs.dto.request.key_result.UpdateKeyResultRequest;
import org.aibles.OKRs.dto.response.KeyResultResponse;

public interface KeyResultService {

  /**
   * create a key result
   * @param request - from client
   * @return a response of created key result
   */
  KeyResultResponse create(CreateKeyResultRequest request);

  /**
   * delete a key result by id
   * @param id - of a key result
   */
  void delete(long id);

  /**
   * get a key result by id
   * @param id - of a key result
   * @return a response of a key result
   */
  KeyResultResponse getById(long id);

  /**
   * update a key result by id
   * @param id - of a key result
   * @param request - from client
   * @return a response of an updated key result
   */
  KeyResultResponse update(long id, UpdateKeyResultRequest request);
}
