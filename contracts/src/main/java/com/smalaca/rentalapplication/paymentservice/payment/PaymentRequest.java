package com.smalaca.rentalapplication.paymentservice.payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class PaymentRequest {
    private String senderId;
    private String recipientId;
    private BigDecimal amount;
}
