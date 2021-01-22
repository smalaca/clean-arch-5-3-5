package com.smalaca.rentalapplication.addressservice.addressverifiacation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static java.util.Arrays.asList;

public class AddressVerificationContract {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<AddressVerificationScenario> scenarios() {
        return asList(validAddress(), invalidAddress());
    }

    public AddressVerificationScenario validAddress() {
        AddressVerificationRequest request = new AddressVerificationRequest("Pawia", "1", "31-154", "Cracow", "Poland");
        AddressVerificationResponse response = new AddressVerificationResponse("VALID");

        return new AddressVerificationScenario(objectMapper, request, response);
    }

    public AddressVerificationScenario invalidAddress() {
        AddressVerificationRequest request = new AddressVerificationRequest("Nowhere", "13", "12-345", "IDontKnow", "Somewhere");
        AddressVerificationResponse response = new AddressVerificationResponse("INVALID");

        return new AddressVerificationScenario(objectMapper, request, response);
    }
}
