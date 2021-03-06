package com.smalaca.addressservice.infrastructure.api.rest;

import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationContract;
import com.smalaca.rentalapplication.addressservice.addressverifiacation.AddressVerificationScenario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressRestControllerSystemTest {
    private final AddressVerificationContract contract = new AddressVerificationContract();

    @Autowired private MockMvc mockMvc;

    @Test
    void shouldRecognizeValidAddress() throws Exception {
        AddressVerificationScenario scenario = contract.validAddress();

        String actual = verifyAddress(scenario);

        assertThat(actual).isEqualTo(scenario.getResponseAsJson());
    }

    @Test
    void shouldRecognizeInvalidAddress() throws Exception {
        AddressVerificationScenario scenario = contract.invalidAddress();

        String actual = verifyAddress(scenario);

        assertThat(actual).isEqualTo(scenario.getResponseAsJson());
    }

    private String verifyAddress(AddressVerificationScenario scenario) throws Exception {
        MvcResult result = mockMvc.perform(post("/address/verify").contentType(MediaType.APPLICATION_JSON).content(scenario.getRequestAsJson()))
                .andExpect(status().isOk())
                .andReturn();

        return result.getResponse().getContentAsString();
    }
}