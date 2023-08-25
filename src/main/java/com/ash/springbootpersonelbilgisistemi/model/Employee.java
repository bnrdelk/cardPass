package com.ash.springbootpersonelbilgisistemi.model;

import javax.persistence.*;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-inc
    private Long Id;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "mail", unique = true, nullable = false)
    private String mail;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Transient
    private String token;
}