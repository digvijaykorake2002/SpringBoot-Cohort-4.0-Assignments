package com.m4assignment.CurrencyConverterApplication.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponseDTO {

    private Map<String, Double> data;
}
