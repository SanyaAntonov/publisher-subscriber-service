package ru.antonov.subscriber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.antonov.subscriber.dto.PublisherRequestDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.antonov.subscriber.enums.Action.PURCHASE;
import static ru.antonov.subscriber.enums.Action.SUBSCRIPTION;

@SpringBootTest
@AutoConfigureMockMvc
class SubscriberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void receiveRequest() throws Exception {
        PublisherRequestDto requestDto = new PublisherRequestDto();
        requestDto.setId(1);
        requestDto.setMsisdn(912601290);
        requestDto.setTimestamp(System.currentTimeMillis() / 1000L);
        requestDto.setAction(PURCHASE);


        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsBytes(requestDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        requestDto.setAction(SUBSCRIPTION);

        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsBytes(requestDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        requestDto.setId(-24);

        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsBytes(requestDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        requestDto.setId(5);
        requestDto.setTimestamp(-4L);
        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsBytes(requestDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        requestDto.setTimestamp(System.currentTimeMillis() / 1000L);
        requestDto.setMsisdn(-228);

        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsBytes(requestDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}