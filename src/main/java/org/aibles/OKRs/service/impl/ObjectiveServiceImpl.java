package org.aibles.OKRs.service.impl;

import static org.aibles.OKRs.constants.CommonConstants.DUPLICATE_KEY_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.OKRs.dto.request.CreateObjectiveRequest;
import org.aibles.OKRs.dto.request.UpdateObjectiveRequest;
import org.aibles.OKRs.dto.response.ObjectiveResponse;
import org.aibles.OKRs.entity.Objective;
import org.aibles.OKRs.exception.BadRequestException;
import org.aibles.OKRs.exception.ExistedException;
import org.aibles.OKRs.exception.NotFoundException;
import org.aibles.OKRs.repository.ObjectiveRepository;
import org.aibles.OKRs.service.ObjectiveService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class ObjectiveServiceImpl implements ObjectiveService {

  private static final String OBJECTIVE_ID_FIELD = "objectiveId";
  private static final String TITLE_FIELD = "title";

  private static final String OBJECTIVE_TYPE = "objective";
  private final ObjectiveRepository repository;

  private Boolean checkObjectiveDate(int startDate, int dueDate) {
    return dueDate > startDate;
  }

  @Override
  @Transactional
  public ObjectiveResponse create(CreateObjectiveRequest request) {
    log.info("(create)title : {}", request.getTitle());
    if (repository.existsByTitle(request.getTitle())) {
      throw new ExistedException(TITLE_FIELD, request.getTitle(), OBJECTIVE_TYPE);
    }
    if (!checkObjectiveDate(request.getStartDate(), request.getDueDate())) {
      throw new BadRequestException();
    }
    try {
      return ObjectiveResponse.from(repository.save(request.toObjective()));
    } catch (DuplicateKeyException ex) {
      log.error("(create)ex : {}", ex.getClass().getName());
      throw new DuplicateKeyException(DUPLICATE_KEY_MESSAGE);
    }
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    log.info("(deleteById)id : {}", id);
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new NotFoundException(OBJECTIVE_ID_FIELD, id, OBJECTIVE_TYPE);
    }
  }

  @Override
  @Transactional(readOnly = true)
  public ObjectiveResponse getById(long id) {
    log.info("(getById)id : {}", id);
    return repository
        .findById(id)
        .map(ObjectiveResponse::from)
        .orElseThrow(() -> new NotFoundException(OBJECTIVE_ID_FIELD, id, OBJECTIVE_TYPE));
  }

  @Override
  @Transactional(readOnly = true)
  public List<ObjectiveResponse> list() {
    log.info("(list)");
    return repository.findAll().stream().map(ObjectiveResponse::from).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public ObjectiveResponse update(long id, UpdateObjectiveRequest request) {
    log.info("(update)title : {}, id : {}", request.getTitle(), id);
    if (!checkObjectiveDate(request.getStartDate(), request.getDueDate())) {
      throw new BadRequestException();
    }
    try {
      Objective objective =
          repository
              .findById(id)
              .map(request::toObjective)
              .orElseThrow(() -> new NotFoundException(OBJECTIVE_ID_FIELD, id, OBJECTIVE_TYPE));
      return ObjectiveResponse.from(repository.save(objective));
    } catch (DuplicateKeyException ex) {
      log.error("(update)ex : {}", ex.getClass().getName());
      throw new DuplicateKeyException(DUPLICATE_KEY_MESSAGE);
    }
  }
}
