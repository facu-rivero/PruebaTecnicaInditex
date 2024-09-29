package com.pruebatecnicabcnc.priceservice;

import com.pruebatecnicabcnc.priceservice.model.Prices;
import com.pruebatecnicabcnc.priceservice.repository.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PricesRepository pricesRepository;

    @BeforeEach
    void setUp() {

        pricesRepository.deleteAll();
        loadTestData();
    }

    void loadTestData() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Prices price1 = new Prices(1L, 1L, LocalDateTime.parse("2024-09-14 00:00:00", formatter),
                LocalDateTime.parse("2024-12-31 23:59:59", formatter), 1L,
                35455L, 0, 35.50, "EUR");
        pricesRepository.save(price1);

    }

    @Test
    void testGetPrice() throws Exception {
        mockMvc.perform(get("/v1/api/prices")
                        .param("applicationDate", "2024-09-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

}
