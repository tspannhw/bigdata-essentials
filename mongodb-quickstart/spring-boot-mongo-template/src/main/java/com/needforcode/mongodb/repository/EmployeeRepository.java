package com.needforcode.mongodb.repository;

import com.needforcode.mongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    Employee findByempId(String id);

    List<Employee> findByempName(String lastName);

}
