package com.example.nameprinter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/name 요청 시 '이혜연'을 반환한다")
    void nameEndpointReturnsMyName() throws Exception {
        mockMvc.perform(get("/name"))
                .andExpect(status().isOk())
                .andExpect(content().string("이혜연"));
    }
}
