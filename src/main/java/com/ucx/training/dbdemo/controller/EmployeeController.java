package com.ucx.training.dbdemo.controller;

import com.ucx.training.dbdemo.service.EmployeeService;
import com.ucx.training.dbdemo.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Rest Interface implementation for employees
 *
 */
@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * This method receives Employee as request body and persists it in underlying DB
     *
     * @param employee
     * @return
     */
    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        Employee newEmp = employeeService.save(employee);
        return ResponseEntity.ok().body(newEmp);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee updatedEmp = employeeService.update(employee);
        return ResponseEntity.ok().body(updatedEmp);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> get(@RequestParam("name") String name){
        List<Employee> foundEmployees = employeeService.findByName(name);
        return ResponseEntity.ok().body(foundEmployees);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Map<String, Object>>> getEmployeeEvents(@PathVariable("id") Integer id){
        List<Map<String, Object>> employeeEvents = employeeService.findEmployeeEvents(id);
        return ResponseEntity.ok().body(employeeEvents);
    }
}
