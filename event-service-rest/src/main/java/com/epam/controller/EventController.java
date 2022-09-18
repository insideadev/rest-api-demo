package com.epam.controller;

import com.epam.dto.EventDto;
import com.epam.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventDto dto) {
        return ResponseEntity.ok(eventService.createEvent(dto));
    }

    @PutMapping
    public ResponseEntity<?> updateEvent(@RequestBody EventDto dto) {
        return ResponseEntity.ok(eventService.updateEvent(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable long id) {
        return ResponseEntity.ok(eventService.deletedEvent(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping
    public ResponseEntity<?> getAllEventsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(eventService.getAllEventsByTitle(title));
    }

}
