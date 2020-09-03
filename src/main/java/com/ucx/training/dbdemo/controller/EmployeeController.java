package com.ucx.training.dbdemo.controller;

import com.ucx.training.dbdemo.entity.Employee;
import com.ucx.training.dbdemo.exception.ResponseException;
import com.ucx.training.dbdemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
@Slf4j
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
    public ResponseEntity<Employee> add(@RequestBody Employee employee) throws ResponseException{
        try {
            Employee newEmp = employeeService.save(employee);
            return ResponseEntity.ok().body(newEmp);
        }catch(Exception ex){
             log.error(ex.getMessage());
             throw new ResponseException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This method updates Employee with the data passed in RequestBody
     *
     * @param employee
     * @return
     */
    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee updatedEmp = employeeService.update(employee);
        return ResponseEntity.ok().body(updatedEmp);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Integer id) throws ResponseException{
        try {
            Employee foundEmployee = employeeService.findById(id);
            return ResponseEntity.ok().body(foundEmployee);
        }catch(Exception ex){
            log.error(ex.getMessage());
            throw new ResponseException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getEmployeeEvents(@RequestParam("id") Integer id){
        List<Map<String, Object>> employeeEvents = employeeService.findEmployeeEvents(id);
        return ResponseEntity.ok().body(employeeEvents);
    }
}
