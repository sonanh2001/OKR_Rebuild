package org.aibles.OKRs.controller;

import static org.aibles.OKRs.constants.APIConstants.API_SOURCE;
import static org.aibles.OKRs.constants.APIConstants.OBJECTIVE_RESOURCES;
import static org.aibles.OKRs.constants.APIConstants.VERSION;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.OKRs.dto.request.objective.CreateObjectiveRequest;
import org.aibles.OKRs.dto.request.objective.UpdateObjectiveRequest;
import org.aibles.OKRs.dto.response.ObjectiveResponse;
import org.aibles.OKRs.service.ObjectiveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping('/' + API_SOURCE + '/' + VERSION + '/' + OBJECTIVE_RESOURCES)
@RequiredArgsConstructor
@Slf4j
public class ObjectiveController {
  private final ObjectiveService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ObjectiveResponse create(@RequestBody @Valid CreateObjectiveRequest request) {
    log.info("(create)title : {}", request.getTitle());
    return service.create(request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") long id) {
    log.info("(deleteById)id : {}", id);
    service.deleteById(id);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ObjectiveResponse getById(@PathVariable("id") long id) {
    log.info("(getById)id : {}", id);
    return service.getById(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ObjectiveResponse> list() {
    log.info("(list)");
    return service.list();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ObjectiveResponse update(@PathVariable("id") long id, @RequestBody @Valid
      UpdateObjectiveRequest request) {
    log.info("(update)id : {}, title : {}", id, request.getTitle());
    return service.update(id, request);
  }
}
