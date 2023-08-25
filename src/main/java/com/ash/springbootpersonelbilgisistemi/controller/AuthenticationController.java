package com.ash.springbootpersonelbilgisistemi.controller;

import com.ash.springbootpersonelbilgisistemi.model.Employee;
import com.ash.springbootpersonelbilgisistemi.service.IAuthenticationService;
import com.ash.springbootpersonelbilgisistemi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController
{
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody Employee employee)
    {
        if (employeeService.findByMail(employee.getMail()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(employee), HttpStatus.OK);
    }
}

