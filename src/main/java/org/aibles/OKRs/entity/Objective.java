package org.aibles.OKRs.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "objective")
public class Objective {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long objectiveId;
  @Column(nullable = false, unique = true)
  private String title;
  @Column(nullable = false)
  private String mentor;

  private String type;
  @Column(nullable = false)
  private String reason;
  @Column(nullable = false)
  private Long startDate;
  @Column(nullable = false)
  private Long dueDate;
  private Long createdAt;
  private Long updatedAt;

  @PrePersist
  private void init() {
    this.createdAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
  }

  @PreUpdate
  private void update() {
    this.updatedAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Objective objective = (Objective) o;
    return objectiveId != null && Objects.equals(objectiveId, objective.objectiveId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
