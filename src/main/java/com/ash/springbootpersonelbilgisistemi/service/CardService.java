package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Card;
import com.ash.springbootpersonelbilgisistemi.model.Employee;
import com.ash.springbootpersonelbilgisistemi.repository.ICardRepository;
import com.ash.springbootpersonelbilgisistemi.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Optional<Card> findById(Long Id) {
        return cardRepository.findById(Id);
    }

    @Override
    public Card createCardForEmployee(Employee employee) {
        Card card = new Card();

        card.setEmployee(employee);
        card.setUpdateTime(LocalDateTime.now());
        card.setRegistrationTime(LocalDateTime.now());

        return cardRepository.save(card);
    }

    @Override
    public Card saveCard(Card card){
        card.setUpdateTime(LocalDateTime.now());

        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long Id) {
        cardRepository.deleteById(Id);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}