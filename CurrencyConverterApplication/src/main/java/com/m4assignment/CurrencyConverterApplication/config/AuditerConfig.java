package com.m4assignment.CurrencyConverterApplication.config;

import com.m4assignment.CurrencyConverterApplication.auth.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl" )
public class AuditerConfig {

    @Bean
    public AuditorAware<String> getAuditorAwareImpl(){
        return new AuditorAwareImpl();
    }
}
