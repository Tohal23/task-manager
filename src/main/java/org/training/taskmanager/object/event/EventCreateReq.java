package org.training.taskmanager.object.event;

import java.time.LocalDateTime;
import java.util.Set;

public class EventCreateReq {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private String description;
    private String eventTypeName;
    private Set<String> eventTagNames;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Set<String> getEventTagNames() {
        return eventTagNames;
    }

    public void setEventTagNames(Set<String> eventTagNames) {
        this.eventTagNames = eventTagNames;
    }
}
