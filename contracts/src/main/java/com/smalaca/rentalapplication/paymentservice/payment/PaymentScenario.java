package com.smalaca.rentalapplication.paymentservice.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentScenario {
    private final ObjectMapper objectMapper;
    private final PaymentRequest request;
    private final PaymentResponse response;

    public PaymentRequest getRequest() {
        return request;
    }

    public String getRequestAsJson() {
        return asJson(getRequest());
    }

    public PaymentResponse getResponse() {
        return response;
    }

    public String getResponseAsJson() {
        return asJson(getResponse());
    }

    private String asJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
