package com.smalaca.rentalapplication.paymentservice.payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class PaymentResponse {
    private String status;

    static PaymentResponse success() {
        return new PaymentResponse("SUCCESS");
    }

    static PaymentResponse notEnoughMoney() {
        return new PaymentResponse("NOT_ENOUGH_RESOURCES");
    }
}
