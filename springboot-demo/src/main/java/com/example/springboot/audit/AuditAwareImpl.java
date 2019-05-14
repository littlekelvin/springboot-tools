package com.example.springboot.audit;

import com.example.springboot.mongodb.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Component("auditAware")
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("kelvin" + (int)(Math.random() * 100));
    }
}
