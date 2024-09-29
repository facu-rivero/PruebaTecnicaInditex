package com.pruebatecnicabcnc.priceservice.controller;

import com.pruebatecnicabcnc.priceservice.dto.PricesDto;
import com.pruebatecnicabcnc.priceservice.service.PricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesController.class)
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;

    private PricesDto mockPricesDto;

    @BeforeEach
    void setUp() {
        // Inicializo los mocks de Mockito
        MockitoAnnotations.initMocks(this);

        // Creo un PricesDto de ejemplo
        mockPricesDto = new PricesDto();
        mockPricesDto.setProductId(35455L);
        mockPricesDto.setBrandId(1L);
        mockPricesDto.setPriceList(1L);
        mockPricesDto.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mockPricesDto.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mockPricesDto.setPrice(35.50);
    }

    @Test
    void testGetPrice() throws Exception {

        when(pricesService.getPrice(any(LocalDateTime.class), any(Long.class), any(Long.class)))
                .thenReturn(mockPricesDto);

        // Realizo una petición GET a la API con los parámetros esperados
        mockMvc.perform(get("/v1/api/prices")
                        .param("applicationDate", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))

                // Verifico que el estado de la respuesta sea 200 OK
                .andExpect(status().isOk())

                // Verifico que los campos de la respuesta tengan los datos esperados
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));
    }
}
