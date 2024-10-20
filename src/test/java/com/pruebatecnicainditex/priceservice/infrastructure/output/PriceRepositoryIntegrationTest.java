package com.pruebatecnicainditex.priceservice.infrastructure.output;

import com.pruebatecnicainditex.priceservice.PriceServiceApplicationTests;
import com.pruebatecnicainditex.priceservice.domain.model.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PriceRepositoryIntegrationTest extends PriceServiceApplicationTests {

    @Autowired
    private SpringDataPricesRepository pricesRepository;

    @Test
    void testFindFirstByProductIdAndBrandId() {

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime startDate = LocalDateTime.of(2024, 9, 14, 10, 00,00);
        LocalDateTime endDate = startDate;


        Optional<Prices> price = pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, startDate, endDate);


        assertThat(price).isPresent();
        assertThat(price.get().getPrice()).isNotNull();
        assertThat(price.get().getProductId()).isEqualTo(productId);
        assertThat(price.get().getBrandId()).isEqualTo(brandId);
    }
}
