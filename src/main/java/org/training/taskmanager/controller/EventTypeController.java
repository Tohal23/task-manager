package org.training.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.taskmanager.object.event.type.EventTypeObj;
import org.training.taskmanager.service.EventTypeService;

import java.util.Set;

@RestController
@RequestMapping("/event-type")
public class EventTypeController {
    private final EventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @GetMapping
    public ResponseEntity<Set<EventTypeObj>> getAllEvents() {
        return ResponseEntity.ok(eventTypeService.getAllEventTypes());
    }

    @GetMapping("/{idEventType}")
    public ResponseEntity<EventTypeObj> getEventById(@PathVariable Long idEventType) {
        return ResponseEntity.ok(eventTypeService.getEventTypeObjById(idEventType));
    }

    @DeleteMapping("/{idEventType}")
    public void deleteEventById(@PathVariable Long idEventType) {
        eventTypeService.deleteEventTypeById(idEventType);
    }

    @PutMapping("/{idEventType}")
    public void updateEventById(@PathVariable Long idEventType, @RequestBody EventTypeObj eventTypeObj) {
        eventTypeService.updateEventType(idEventType, eventTypeObj);
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventTypeObj eventTypeObj) {
        return ResponseEntity.ok(eventTypeService.createEventType(eventTypeObj));
    }
}
