package org.training.taskmanager.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @PreUpdate
    public void setModifiedDate() {
        this.modifiedDate = LocalDateTime.now();
    }

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }
}
