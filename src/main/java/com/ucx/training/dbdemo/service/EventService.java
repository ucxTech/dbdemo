package com.ucx.training.dbdemo.service;

import com.ucx.training.dbdemo.entity.Event;
import com.ucx.training.dbdemo.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EmployeeService employeeService;

    private final EventRepository eventRepository;

    public EventService(EmployeeService employee, EventRepository eventRepository) {
        this.employeeService = employee;
        this.eventRepository = eventRepository;
    }

    public Event save(Event event, Integer employeeId){
        event.setEmployee(employeeService.findById(employeeId));
        return eventRepository.save(event);
    }
}
