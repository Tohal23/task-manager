package org.training.taskmanager.service;

import org.springframework.stereotype.Service;
import org.training.taskmanager.model.EventType;
import org.training.taskmanager.object.event.type.EventTypeObj;
import org.training.taskmanager.repository.EventTypeRep;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventTypeService {

    private final EventTypeRep eventTypeRep;

    public EventTypeService(EventTypeRep eventTypeRep) {
        this.eventTypeRep = eventTypeRep;
    }

    public Set<EventTypeObj> getAllEventTypes() {
        Set<EventType> eventTypes = new HashSet<>((Collection<EventType>) eventTypeRep.findAll());
        return eventTypes.stream().map(eventType -> new EventTypeObj(eventType.getId(), eventType.getName()))
                .collect(Collectors.toSet());
    }

    public EventTypeObj getEventTypeObjById(Long idEventType) {
        return new EventTypeObj(idEventType, getEventTypeById(idEventType).getName());
    }

    public void deleteEventTypeById(Long idEvent) {
        eventTypeRep.delete(getEventTypeById(idEvent));
    }

    public Long createEventType(EventTypeObj eventTypeObj) {
        EventType eventType = new EventType();
        eventType.setName(eventTypeObj.getName());
        eventTypeRep.save(eventType);

        return eventType.getId();
    }

    public void updateEventType(Long idEventType, EventTypeObj eventTypeObj) {
        EventType eventType = getEventTypeById(idEventType);

        eventType.setName(eventTypeObj.getName());

        eventTypeRep.save(eventType);
    }

    private EventType getEventTypeById(Long idEventType) {
        return eventTypeRep.findById(idEventType).get();
    }
}
