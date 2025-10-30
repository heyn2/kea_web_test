package com.example.nameprinter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameServiceTest {

    @Test
    @DisplayName("getMyName()은 '이혜연'을 반환한다")
    void returnsMyName() {
        NameService service = new NameService();
        assertEquals("이혜연", service.getMyName());
    }
}
