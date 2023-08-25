package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Optional<Employee> findByName(String name);

    Optional<Employee> findByMail(String mail);

    List<Employee> getAllEmployees();

    @Transactional
    void makeAdmin(String mail);

    @Transactional
    void updateEmployeeName(String mail, String name);
}
