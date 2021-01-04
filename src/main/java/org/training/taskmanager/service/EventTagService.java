package org.training.taskmanager.service;

import org.springframework.stereotype.Service;
import org.training.taskmanager.model.EventTag;
import org.training.taskmanager.object.event.tag.EventTagObj;
import org.training.taskmanager.repository.EventTagRep;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventTagService {
    private final EventTagRep eventTagRep;

    public EventTagService(EventTagRep eventTagRep) {
        this.eventTagRep = eventTagRep;
    }

    public Set<EventTagObj> getAllEventTags() {
        Set<EventTag> eventTags = new HashSet<>((Collection<EventTag>) eventTagRep.findAll());
        return eventTags.stream().map(eventTag -> new EventTagObj(eventTag.getId(), eventTag.getName()))
                .collect(Collectors.toSet());
    }

    public EventTagObj getEventTagObjById(Long idEventTag) {
        EventTag eventTag = getEventTagById(idEventTag);
        return new EventTagObj(eventTag.getId(), eventTag.getName());
    }

    public void deleteEventTagById(Long idEvent) {
        eventTagRep.delete(getEventTagById(idEvent));
    }

    public Long createEventTag(EventTagObj eventTagObj) {
        EventTag eventTag = new EventTag();
        eventTag.setName(eventTagObj.getName());
        eventTagRep.save(eventTag);

        return eventTag.getId();
    }

    public void updateEventTag(Long idEventTag, EventTagObj eventTagObj) {
        EventTag eventTag = getEventTagById(idEventTag);

        eventTag.setName(eventTagObj.getName());

        eventTagRep.save(eventTag);
    }

    private EventTag getEventTagById(Long idEventTag) {
        return eventTagRep.findById(idEventTag).get();
    }
}
