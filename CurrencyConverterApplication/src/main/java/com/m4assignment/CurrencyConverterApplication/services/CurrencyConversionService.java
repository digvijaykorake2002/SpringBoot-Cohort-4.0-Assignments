package com.m4assignment.CurrencyConverterApplication.services;

import com.m4assignment.CurrencyConverterApplication.dto.CurrencyResponseDTO;
import com.m4assignment.CurrencyConverterApplication.entities.CurrencyConversion;
import com.m4assignment.CurrencyConverterApplication.repositories.CurrencyConversionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyConversionService {

    private final CurrencyConversionRepository conversionRepository;
    private final RestClient restClient;

    @Value("${CURRENCY_API_KEY}")
    private String apikey;

    public double ConvertCurrency(String from, String to, double units){

        log.info("Calling FreeCurrencyAPI for {} to {}" ,from,to );

        CurrencyResponseDTO response = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/latest").queryParam("apikey",apikey)
                        .queryParam("base_currency", from).queryParam("currencies", to).build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        double rate = response.getData().get(to);
        double convertedAmount = rate*units;

        log.debug("Exchange rate: {}, Converted amount: {}", rate, convertedAmount);

        CurrencyConversion conversion = new CurrencyConversion();

        conversion.setFrom_currency(from);
        conversion.setTo_currency(to);
        conversion.setRate(rate);
        conversion.setUnits(units);
        conversion.setConvertedAmount(convertedAmount);
        log.info("Saved Conversion of Currency Succesfully");

        conversionRepository.save(conversion);

        return convertedAmount;

    }
}
