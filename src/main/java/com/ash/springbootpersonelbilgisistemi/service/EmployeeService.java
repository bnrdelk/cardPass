package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Employee;

import com.ash.springbootpersonelbilgisistemi.model.Role;
import com.ash.springbootpersonelbilgisistemi.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ICardService cardService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setMail(employee.getMail());
        employee.setName(employee.getName());
        employee.setSurname(employee.getSurname());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setRegistrationTime(LocalDateTime.now());
        employee.setRole(Role.USER);
        employeeRepository.save(employee);
        cardService.createCardForEmployee(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setMail(employee.getMail());
        employee.setName(employee.getName());
        employee.setSurname(employee.getSurname());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setRole(Role.USER);
        employeeRepository.save(employee);

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findByName(String name){
        return employeeRepository.findByName(name);
    }

    @Override
    public Optional<Employee> findByMail(String mail) {
        return employeeRepository.findByMail(mail);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void makeAdmin(String mail)
    {
        employeeRepository.updateEmployeeRole(mail, Role.ADMIN);
    }


    @Override
    @Transactional
    public void updateEmployeeName(String mail, String name) {
        employeeRepository.updateEmployeeName(mail, name);
    }


}
