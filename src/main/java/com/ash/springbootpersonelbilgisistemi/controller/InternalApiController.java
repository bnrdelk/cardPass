package com.ash.springbootpersonelbilgisistemi.controller;

import com.ash.springbootpersonelbilgisistemi.model.Card;
import com.ash.springbootpersonelbilgisistemi.service.ICardService;
import com.ash.springbootpersonelbilgisistemi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICardService cardService;

    @PutMapping("make-admin/{mail}")
    public ResponseEntity<?> makeAdmin(@PathVariable String mail){
        employeeService.makeAdmin(mail);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
