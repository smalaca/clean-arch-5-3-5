package com.smalaca.paymentservice.infrastructure.api.rest;

import com.smalaca.rentalapplication.paymentservice.payment.PaymentContract;
import com.smalaca.rentalapplication.paymentservice.payment.PaymentScenario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentRestControllerSystemTest {
    private final PaymentContract contract = new PaymentContract();

    @Autowired private MockMvc mockMvc;

    @Test
    void shouldSuccessfullyCompletePayment() throws Exception {
        PaymentScenario scenario = contract.successfulPayment();

        String actual = pay(scenario);

        assertThat(actual).isEqualTo(scenario.getResponseAsJson());
    }

    @Test
    void shouldRecognizeThereIsNotEnoughResources() throws Exception {
        PaymentScenario scenario = contract.notEnoughMoney();

        String actual = pay(scenario);

        assertThat(actual).isEqualTo(scenario.getResponseAsJson());
    }

    private String pay(PaymentScenario scenario) throws Exception {
        return mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON).content(scenario.getRequestAsJson()))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}