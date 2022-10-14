package org.aibles.OKRs.service;

import java.util.List;
import org.aibles.OKRs.dto.request.objective.CreateObjectiveRequest;
import org.aibles.OKRs.dto.request.objective.UpdateObjectiveRequest;
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
   * check an objective exist or not by id
   * @param id - from client
   * @return true or false
   */
  Boolean existsById(long id);

  /**
   * get an objective by id
   * @param id - from client
   * @return a response of an objective
   */
  ObjectiveResponse getById(long id);

  /**
   * get due date of an objective
   * @param id - of an objective
   * @return due date of an objective
   */
  Long getDueDateById(long id);

  /**
   * get start date of an objective
   * @param id - of an objective
   * @return start date of an objective
   */
  Long getStartDateById(long id);
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
