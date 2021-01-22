package com.smalaca.paymentservice.infrastructure.api.rest;

import com.smalaca.rentalapplication.paymentservice.payment.PaymentContract;
import com.smalaca.rentalapplication.paymentservice.payment.PaymentRequest;
import com.smalaca.rentalapplication.paymentservice.payment.PaymentResponse;
import com.smalaca.rentalapplication.paymentservice.payment.PaymentScenario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentRestController {
    private final PaymentContract contract = new PaymentContract();

    @PostMapping
    public PaymentResponse pay(@RequestBody PaymentRequest request) {
        return contract.scenarios().stream()
                .filter(paymentScenario -> paymentScenario.getRequest().equals(request))
                .map(PaymentScenario::getResponse)
                .findFirst()
                .get();
    }
}
