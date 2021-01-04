package org.training.taskmanager.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.training.taskmanager.model.Event;
import org.training.taskmanager.model.Usr;
import org.training.taskmanager.object.event.EventCreateReq;
import org.training.taskmanager.object.event.EventResp;
import org.training.taskmanager.object.event.tag.EventTagObj;
import org.training.taskmanager.object.event.type.EventTypeObj;
import org.training.taskmanager.repository.EventRep;
import org.training.taskmanager.repository.EventTagRep;
import org.training.taskmanager.repository.EventTypeRep;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRep eventRep;
    private final EventTypeRep eventTypeRep;
    private final EventTagRep eventTagRep;

    public EventService(EventRep eventRep, EventTypeRep eventTypeRep, EventTagRep eventTagRep) {
        this.eventRep = eventRep;
        this.eventTypeRep = eventTypeRep;
        this.eventTagRep = eventTagRep;
    }

    public Set<EventResp> getAllEvents() {
        Set<Event> events = eventRep.findAllByOwner(getCurrentUsr());
        return events.stream().map(this::getEventRespFromEvent).collect(Collectors.toSet());
    }

    public EventResp getEventRespById(Long idEvent) {
        return getEventRespFromEvent(getEventById(idEvent));
    }

    public void deleteEventById(Long idEvent) {
        eventRep.delete(getEventById(idEvent));
    }

    public Long createEvent(EventCreateReq eventCreateReq) {
        Event event = getEventFromEventCreateReq(new Event(), eventCreateReq);
        eventRep.save(event);

        return event.getId();
    }

    public void updateEvent(Long idEvent, EventCreateReq eventCreateReq) {
        Event event = getEventFromEventCreateReq(getEventById(idEvent), eventCreateReq);
        eventRep.save(event);
    }

    private Event getEventById(Long idEvent) {
        return eventRep.findById(idEvent).get();
    }

    private Event getEventFromEventCreateReq(Event event, EventCreateReq eventCreateReq) {
        event.setName(eventCreateReq.getName());
        event.setDescription(eventCreateReq.getDescription());
        event.setStartDate(eventCreateReq.getStartDate());
        event.setEndDate(eventCreateReq.getEndDate());
        event.setEventType(eventTypeRep.findByName(eventCreateReq.getEventTypeName()));
        event.setTags(eventCreateReq.getEventTagNames().stream()
                .map(eventTagRep::findByName).collect(Collectors.toSet())
        );
        event.setOwner(getCurrentUsr());

        return event;
    }

    private EventResp getEventRespFromEvent(Event event) {
        EventResp eventResp = new EventResp();
        eventResp.setName(event.getName());
        eventResp.setDescription(event.getDescription());
        eventResp.setStartDate(event.getStartDate());
        eventResp.setEndDate(event.getEndDate());
        eventResp.setEventType(new EventTypeObj(event.getId(), event.getEventType().getName()));
        eventResp.setTags(event.getTags().stream()
                            .map(tag -> new EventTagObj(tag.getId(), tag.getName()))
                 .collect(Collectors.toSet())
        );

        return eventResp;
    }

    private Usr getCurrentUsr() {
        return  (Usr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
