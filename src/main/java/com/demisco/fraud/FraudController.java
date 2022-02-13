package com.demisco.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(@PathVariable Long customerId) {
        Boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
        return new FraudResponse(isFraudulentCustomer);
    }
}
