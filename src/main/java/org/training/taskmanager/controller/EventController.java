package org.training.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.taskmanager.object.event.EventCreateReq;
import org.training.taskmanager.object.event.EventResp;
import org.training.taskmanager.service.EventService;

import java.util.Set;

@RestController
@RequestMapping("event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<Set<EventResp>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{idEvent}")
    public ResponseEntity<EventResp> getEventById(@PathVariable Long idEvent) {
        return ResponseEntity.ok(eventService.getEventRespById(idEvent));
    }

    @DeleteMapping("/{idEvent}")
    public void deleteEventById(@PathVariable Long idEvent) {
        eventService.deleteEventById(idEvent);
    }

    @PutMapping("/{idEvent}")
    public void updateEventById(@PathVariable Long idEvent, @RequestBody EventCreateReq eventCreateReq) {
        eventService.updateEvent(idEvent, eventCreateReq);
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventCreateReq eventCreateReq) {
        return ResponseEntity.ok(eventService.createEvent(eventCreateReq));
    }

}
