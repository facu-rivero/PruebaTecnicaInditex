package com.pruebatecnicainditex.priceservice.infrastructure.input;

import com.pruebatecnicainditex.priceservice.PriceServiceApplicationTests;
import com.pruebatecnicainditex.priceservice.infrastructure.dto.PricesDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIntegrationTest extends PriceServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void testGetPriceOk() {

        String url = "/v1/api/prices?applicationDate=2024-09-14 10:00:00&productId=35455&brandId=1";

        ResponseEntity<PricesDto> response = restTemplate.getForEntity(url, PricesDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PricesDto price = response.getBody();
        assertThat(price).isNotNull();
        assertThat(price.getProductId()).isEqualTo(35455L);
        assertThat(price.getBrandId()).isEqualTo(1L);
    }

    @Test
    void testGetPriceError() {

        String url = "http://localhost:" + port + "/v1/api/prices?applicationDate=2024-09-13 10:00:00&productId=99999&brandId=1";

        ResponseEntity<PricesDto> response = restTemplate.getForEntity(url, PricesDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
