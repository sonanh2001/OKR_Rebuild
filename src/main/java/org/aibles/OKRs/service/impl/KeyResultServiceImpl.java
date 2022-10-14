package org.aibles.OKRs.service.impl;

import static org.aibles.OKRs.constants.CommonConstants.DUPLICATE_KEY_MESSAGE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.OKRs.dto.request.key_result.CreateKeyResultRequest;
import org.aibles.OKRs.dto.request.key_result.UpdateKeyResultRequest;
import org.aibles.OKRs.dto.response.KeyResultResponse;
import org.aibles.OKRs.exception.BadRequestException;
import org.aibles.OKRs.exception.ExistedException;
import org.aibles.OKRs.exception.NotFoundException;
import org.aibles.OKRs.repository.KeyResultRepository;
import org.aibles.OKRs.service.KeyResultService;
import org.aibles.OKRs.service.ObjectiveService;
import org.aibles.OKRs.util.DateUtil;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class KeyResultServiceImpl implements KeyResultService {

  private static final String KEY_RESULT_TYPE = "keyResult";
  private static final String KEY_RESULT_ID_FIELD = "keyResultId";
  private static final String TITLE_FIELD = "title";
  private static final String OBJECTIVE_ID_FIELD = "objectiveId";
  private static final String OBJECTIVE_TYPE = "objective";

  private final KeyResultRepository repository;

  private final ObjectiveService objectiveService;

  private Boolean checkKeyResultDate(int startDate, int dueDate, long objectiveId) {
    int startDateObj =
        DateUtil.convertEpochToInteger(objectiveService.getStartDateById(objectiveId));
    int dueDateObj = DateUtil.convertEpochToInteger(objectiveService.getDueDateById(objectiveId));

    if(dueDate < startDate) {
      return false;
    }

    if(startDate < startDateObj || startDate > dueDateObj) {
      return false;
    }

    return dueDate > startDateObj && dueDate <= dueDateObj;
  }

  @Override
  @Transactional
  public KeyResultResponse create(CreateKeyResultRequest request) {
    log.info("(create)title : {}", request.getTitle());
    if (!objectiveService.existsById(request.getObjectiveId())) {
      throw new NotFoundException(OBJECTIVE_ID_FIELD, request.getObjectiveId(), OBJECTIVE_TYPE);
    }
    if (repository.existsByTitle(request.getTitle())) {
      throw new ExistedException(TITLE_FIELD, request.getTitle(), KEY_RESULT_TYPE);
    }
    if(!checkKeyResultDate(request.getStartDate(), request.getDueDate(), request.getObjectiveId())) {
      throw new BadRequestException();
    }

    try {
      return KeyResultResponse.from(repository.save(request.toKeyResult()));
    } catch (DuplicateKeyException ex) {
      log.error("(create)ex : {}", ex.getClass().getName());
      throw new DuplicateKeyException(DUPLICATE_KEY_MESSAGE);
    }
  }

  @Override
  public void delete(long id) {}

  @Override
  public KeyResultResponse getById(long id) {
    return null;
  }

  @Override
  public KeyResultResponse update(long id, UpdateKeyResultRequest request) {
    return null;
  }
}
