package org.training.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.training.taskmanager.model.EventType;

public interface EventTypeRep extends CrudRepository<EventType, Long> {

    EventType findByName(String name);

}
