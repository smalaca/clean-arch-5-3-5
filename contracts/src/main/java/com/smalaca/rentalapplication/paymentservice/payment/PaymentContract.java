package com.smalaca.rentalapplication.paymentservice.payment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

public class PaymentContract {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<PaymentScenario> scenarios() {
        return asList(successfulPayment(), notEnoughMoney());
    }

    public PaymentScenario successfulPayment() {
        PaymentRequest request = new PaymentRequest("TestAccount1", "TestAccount2", BigDecimal.valueOf(123.45));
        return new PaymentScenario(objectMapper, request, PaymentResponse.success());
    }

    public PaymentScenario notEnoughMoney() {
        PaymentRequest request = new PaymentRequest("TestAccountWithNoMoney", "TestAccount2", BigDecimal.valueOf(123.45));
        return new PaymentScenario(objectMapper, request, PaymentResponse.notEnoughMoney());
    }
}
