package com.ash.springbootpersonelbilgisistemi.repository.projection;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;

public interface ITempCard {
    @Value("#{target.pin}")
    Long getPin();
    @Value("#{target.name}")
    String getName();
    @Value("#{target.zaman}")
    Timestamp getZaman();
    @Value("#{target.tarih}")
    String getTarih();
    @Value("#{target.mail}")
    String getMail();
}