package com.ucx.training.dbdemo.controller;

import com.ucx.training.dbdemo.entity.Event;
import com.ucx.training.dbdemo.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/{id}/events")
    public ResponseEntity<Event> add(@PathVariable("id") Integer employeeId,
                                       @RequestBody Event event){
        Event savedEvent = eventService.save(event, employeeId);
        return ResponseEntity.ok().body(savedEvent);
    }
}
