package com.smalaca.rentalapplication.addressservice.addressverifiacation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressVerificationScenario {
    private final ObjectMapper objectMapper;
    private final AddressVerificationRequest request;
    private final AddressVerificationResponse response;

    public AddressVerificationRequest getRequest() {
        return request;
    }

    public String getRequestAsJson() {
        return asJson(request);
    }

    public AddressVerificationResponse getResponse() {
        return response;
    }

    public String getResponseAsJson() {
        return asJson(request);
    }

    private String asJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
