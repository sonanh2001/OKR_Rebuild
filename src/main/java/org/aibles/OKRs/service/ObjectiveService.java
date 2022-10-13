package org.aibles.OKRs.service;

import java.util.List;
import org.aibles.OKRs.dto.request.CreateObjectiveRequest;
import org.aibles.OKRs.dto.request.UpdateObjectiveRequest;
import org.aibles.OKRs.dto.response.ObjectiveResponse;

public interface ObjectiveService {

  /**
   * create an objective
   * @param request - from client
   * @return a response of created objective
   */
  ObjectiveResponse create(CreateObjectiveRequest request);

  /**
   * delete an objective by id
   * @param id - id of an objective
   */
  void deleteById(long id);

  /**
   * get an objective by id
   * @param id - from client
   * @return a response of an objective
   */
  ObjectiveResponse getById(long id);

  /**
   * list all objectives
   * @return a response list of all objectives
   */
  List<ObjectiveResponse> list();

  /**
   * update an objective by id
   * @param id - from client
   * @param request - from client
   * @return a response of an updated objective
   */
  ObjectiveResponse update(long id, UpdateObjectiveRequest request);
}
