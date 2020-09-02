package com.ucx.training.dbdemo.service;

import com.ucx.training.dbdemo.entity.Employee;
import com.ucx.training.dbdemo.repository.EmployeeRepository;
import com.ucx.training.dbdemo.util.TupleHelper;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee emp){
//        Optional<Employee> optionalEmployee = employeeRepository.findById(emp.getId());
//        optionalEmployee.get();
        Employee foundEmployee = findById(emp.getId());
        foundEmployee.setName(emp.getName());
        return employeeRepository.save(foundEmployee);
    }

    public Employee findById(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameIgnoreCase(name);
    }

    public List<Map<String, Object>> findEmployeeEvents(Integer id){
      List<Tuple> resultSet = employeeRepository.findEmployeeEvents(id);
      return  TupleHelper.toList(resultSet);
    }
}
