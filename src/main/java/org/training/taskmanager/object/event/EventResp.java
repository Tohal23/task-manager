package org.training.taskmanager.object.event;

import org.training.taskmanager.object.event.tag.EventTagObj;
import org.training.taskmanager.object.event.type.EventTypeObj;

import java.time.LocalDateTime;
import java.util.Set;

public class EventResp {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Set<EventTagObj> tags;
    private EventTypeObj eventType;

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

    public Set<org.training.taskmanager.object.event.tag.EventTagObj> getTags() {
        return tags;
    }

    public void setTags(Set<org.training.taskmanager.object.event.tag.EventTagObj> tags) {
        this.tags = tags;
    }

    public EventTypeObj getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeObj eventType) {
        this.eventType = eventType;
    }
}
