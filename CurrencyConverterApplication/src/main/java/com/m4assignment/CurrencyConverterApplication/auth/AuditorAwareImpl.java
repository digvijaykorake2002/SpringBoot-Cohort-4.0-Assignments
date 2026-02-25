package com.m4assignment.CurrencyConverterApplication.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        //--------------security
        return Optional.of("Digvijay Dilip Korake");
    }
}
