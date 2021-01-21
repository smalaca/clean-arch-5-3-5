package com.smalaca.addressservice.infrastructure.api.rest;

import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationContract;
import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationRequest;
import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationResponse;
import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationScenario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressRestController {

    @PostMapping("/verify")
    public AddressVerificationResponse verify(@RequestBody AddressVerificationRequest request) {
        return new AddressVerificationContract().scenarios().stream()
                .filter(scenario -> scenario.getRequest().equals(request))
                .map(AddressVerificationScenario::getResponse)
                .findFirst()
                .get();
    }
}
