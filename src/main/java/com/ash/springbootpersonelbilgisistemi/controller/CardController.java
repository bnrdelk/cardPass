package com.ash.springbootpersonelbilgisistemi.controller;

import com.ash.springbootpersonelbilgisistemi.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @DeleteMapping("{cardId}")
    public ResponseEntity<?> deleteCard(@PathVariable Long cardId){
        cardService.deleteCard(cardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCards(){
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }
}
