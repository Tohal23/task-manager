package org.training.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EventType extends BaseModel {
    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
