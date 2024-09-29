package com.pruebatecnicabcnc.priceservice.repository;

import com.pruebatecnicabcnc.priceservice.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    List<Prices> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate
    );
}
