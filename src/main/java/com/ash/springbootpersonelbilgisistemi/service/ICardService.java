package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Card;
import com.ash.springbootpersonelbilgisistemi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICardService {
    Optional<Card> findById(Long Id);

    Card createCardForEmployee(Employee employee);

    Card saveCard(Card card);

    void deleteCard(Long Id);

    List<Card> getAllCards();
}
