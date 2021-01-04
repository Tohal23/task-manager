package org.training.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.training.taskmanager.model.Usr;

public interface UsrRep extends CrudRepository<Usr, Long> {

    Usr findByUsername(String username);

}
