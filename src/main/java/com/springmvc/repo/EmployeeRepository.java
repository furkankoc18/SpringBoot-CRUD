package com.springmvc.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
