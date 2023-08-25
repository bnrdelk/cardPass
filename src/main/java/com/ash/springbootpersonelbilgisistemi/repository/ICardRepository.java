package com.ash.springbootpersonelbilgisistemi.repository;

import com.ash.springbootpersonelbilgisistemi.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ICardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findById(Long Id);

}
