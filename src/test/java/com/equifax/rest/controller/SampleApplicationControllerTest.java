package com.equifax.rest.controller;


import com.equifax.model.GreetingModel;
import com.equifax.service.GreetingService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "dev")
@WebMvcTest(controllers = SampleApplicationController.class)
@Ignore
public class SampleApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    public void getGreeting() throws Exception {
        String id = "Dennis";
        String country = "CHI";
        String message = "Ni hao";
        GreetingModel model = new GreetingModel();
        model.setCountry(country);
        model.setMessage(message);
        model.setFirstName(id);

        given(service.greet("CHI", "Dennis")).willReturn(ResponseEntity.ok(model.toString()));
        mockMvc.perform(get("/1.0/CHI/Dennis")
            .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message))
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(id))
            .andExpect(MockMvcResultMatchers.jsonPath("$.country").value(country));
    }


}
