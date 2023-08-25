package com.ash.springbootpersonelbilgisistemi.model;

import javax.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_temp_card")
public class TempCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "kart_no")
    private int kart_no;

    @Column(name = "pin")
    private int pin;

    @Column(name = "zaman")
    private Timestamp zaman;
}
