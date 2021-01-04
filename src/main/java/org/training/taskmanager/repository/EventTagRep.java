package org.training.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.training.taskmanager.model.EventTag;

public interface EventTagRep extends CrudRepository<EventTag, Long> {

    EventTag findByName(String name);

}
