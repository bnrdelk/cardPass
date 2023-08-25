package com.ash.springbootpersonelbilgisistemi.model;

import javax.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "kart_no")
    private int kart_no;

    @Column(name = "pin")
    private int pin;

    @Column(name = "zaman")
    private Timestamp zaman;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    //!!
    @OneToOne
    private Employee employee;
}