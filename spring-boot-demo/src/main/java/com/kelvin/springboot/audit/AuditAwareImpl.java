package com.kelvin.springboot.audit;

import com.kelvin.springboot.common.UserContextHolder;
import com.kelvin.springboot.entity.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Component("auditAware")
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(UserContextHolder.getUserInfo().getUsername());
    }
}
