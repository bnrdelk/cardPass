package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.TempCard;
import com.ash.springbootpersonelbilgisistemi.repository.projection.ITempCard;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface ITempCardService {
    List<ITempCard> getLatecomersByDay(String prmTarih);

    List<TempCard> getAllCards();
}
