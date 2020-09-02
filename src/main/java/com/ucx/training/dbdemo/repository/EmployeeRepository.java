package com.ucx.training.dbdemo.repository;

import com.ucx.training.dbdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameIgnoreCase(String name);

    @Query(value = "select e.id, e.name, evt.event_type from "+
        "employee e"+
        " join event evt on e.id = evt.employee_id "+
    "where e.id = :id",nativeQuery = true)
    List<Tuple> findEmployeeEvents(@Param("id") Integer id);
}
