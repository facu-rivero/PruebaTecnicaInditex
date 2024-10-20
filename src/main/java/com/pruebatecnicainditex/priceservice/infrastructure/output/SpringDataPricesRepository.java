package com.pruebatecnicainditex.priceservice.infrastructure.output;

import com.pruebatecnicainditex.priceservice.domain.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SpringDataPricesRepository extends JpaRepository<Prices, Long> {

    Optional<Prices> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate
    );
}
