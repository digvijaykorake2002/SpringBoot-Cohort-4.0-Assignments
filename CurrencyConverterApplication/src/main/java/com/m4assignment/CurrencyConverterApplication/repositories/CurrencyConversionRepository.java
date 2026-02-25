package com.m4assignment.CurrencyConverterApplication.repositories;

import com.m4assignment.CurrencyConverterApplication.entities.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion,Long> {
}
