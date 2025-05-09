package com.znaji.accountsmicroservices.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyAuditorAware implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }
}
