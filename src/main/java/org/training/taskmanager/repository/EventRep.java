package org.training.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.training.taskmanager.model.Event;
import org.training.taskmanager.model.Usr;

import java.util.Set;

public interface EventRep extends CrudRepository<Event, Long> {
    Set<Event> findAllByOwner(Usr owner);
}
