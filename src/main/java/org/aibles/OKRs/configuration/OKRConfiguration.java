package org.aibles.OKRs.configuration;

import org.aibles.OKRs.repository.ObjectiveRepository;
import org.aibles.OKRs.service.ObjectiveService;
import org.aibles.OKRs.service.impl.ObjectiveServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"org.aibles.OKRs.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.OKRs.repository"})
public class OKRConfiguration {
  @Bean
  public ObjectiveService objectiveService(ObjectiveRepository repository) {
    return new ObjectiveServiceImpl(repository);
  }
}
