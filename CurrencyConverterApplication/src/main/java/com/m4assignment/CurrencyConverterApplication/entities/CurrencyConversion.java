package com.m4assignment.CurrencyConverterApplication.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currency_conversion")
public class CurrencyConversion extends AuditCurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String from_currency;

    private String to_currency;

    private double units;

    private double rate;

    private double convertedAmount;
}
