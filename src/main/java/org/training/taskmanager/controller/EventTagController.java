package org.training.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.taskmanager.object.event.tag.EventTagObj;
import org.training.taskmanager.service.EventTagService;

import java.util.Set;

@RestController
@RequestMapping("event-tag")
public class EventTagController {
    private final EventTagService eventTagService;

    public EventTagController(EventTagService eventTagService) {
        this.eventTagService = eventTagService;
    }

    @GetMapping
    public ResponseEntity<Set<EventTagObj>> getAllEvents() {
        return ResponseEntity.ok(eventTagService.getAllEventTags());
    }

    @GetMapping("/{idEventTag}")
    public ResponseEntity<EventTagObj> getEventById(@PathVariable Long idEventTag) {
        return ResponseEntity.ok(eventTagService.getEventTagObjById(idEventTag));
    }

    @DeleteMapping("/{idEventTag}")
    public void deleteEventById(@PathVariable Long idEventTag) {
        eventTagService.deleteEventTagById(idEventTag);
    }

    @PutMapping("/{idEventTag}")
    public void updateEventById(@PathVariable Long idEventTag, @RequestBody EventTagObj eventTagObj) {
        eventTagService.updateEventTag(idEventTag, eventTagObj);
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventTagObj eventTagObj) {
        return ResponseEntity.ok(eventTagService.createEventTag(eventTagObj));
    }

}
