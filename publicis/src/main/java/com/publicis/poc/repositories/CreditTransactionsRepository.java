package com.publicis.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publicis.poc.models.CreditTransactions;

@Repository
public interface CreditTransactionsRepository extends JpaRepository<CreditTransactions, Long> {

}
