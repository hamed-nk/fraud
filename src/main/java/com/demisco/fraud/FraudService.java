package com.demisco.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudService {
    private final FraudRepository fraudRepository;

    @Transactional
    public Boolean isFraudulentCustomer(Long customerId) {
        log.info(" fraud check request for customer {}", customerId);
        fraudRepository.save(
                Fraud.builder()
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .isFraudster(true)
                        .build()
        );
        log.info(" fraud check request for customer {}", customerId);
        return Boolean.TRUE;
    }
}
