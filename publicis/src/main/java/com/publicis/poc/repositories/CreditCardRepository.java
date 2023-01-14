package com.publicis.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicis.poc.models.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
