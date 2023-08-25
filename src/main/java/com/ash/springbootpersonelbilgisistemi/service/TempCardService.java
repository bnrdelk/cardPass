package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.TempCard;
import com.ash.springbootpersonelbilgisistemi.repository.ITempCardRepository;
import com.ash.springbootpersonelbilgisistemi.repository.projection.ITempCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempCardService implements ITempCardService{
    @Autowired
    private ITempCardRepository iTempCardRepository;

    @Override
    public List<ITempCard> getLatecomersByDay(String prmTarih) {
        System.out.println(prmTarih);
        return iTempCardRepository.getLatecomersByDay(prmTarih);
    }

    @Override
    public List<TempCard> getAllCards() {
        return iTempCardRepository.findAll();
    }


}