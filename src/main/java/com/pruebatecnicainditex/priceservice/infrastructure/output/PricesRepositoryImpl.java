package com.pruebatecnicainditex.priceservice.infrastructure.output;

import com.pruebatecnicainditex.priceservice.domain.model.Prices;
import com.pruebatecnicainditex.priceservice.domain.ports.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PricesRepositoryImpl implements PricesRepository {

    private final SpringDataPricesRepository springDataPricesRepository;

    @Override
    public Optional<Prices> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long brandId, Long productId, LocalDateTime starDate, LocalDateTime endDate) {
        return springDataPricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, starDate, endDate);
    }
}