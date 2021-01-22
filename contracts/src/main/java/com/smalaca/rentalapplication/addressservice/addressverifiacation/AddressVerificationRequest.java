package com.smalaca.rentalapplication.addressservice.addressverifiacation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressVerificationRequest {
    private String street;
    private String buildingNumber;
    private String postalCode;
    private String city;
    private String country;
}
