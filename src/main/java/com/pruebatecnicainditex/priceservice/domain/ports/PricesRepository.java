package com.pruebatecnicainditex.priceservice.domain.ports;

import com.pruebatecnicainditex.priceservice.domain.model.Prices;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesRepository {
    Optional<Prices> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long brandId, Long productId, LocalDateTime starDate, LocalDateTime endDate);
}
