package com.m4assignment.CurrencyConverterApplication.controllers;

import com.m4assignment.CurrencyConverterApplication.dto.CurrencyResponseDTO;
import com.m4assignment.CurrencyConverterApplication.services.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertCurrency")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService conversionService;

    @GetMapping
    public double ConvertCurrency(@RequestParam String from,
                                               @RequestParam String to,
                                               @RequestParam double units){

         return conversionService.ConvertCurrency(from,to,units);


    }
}
