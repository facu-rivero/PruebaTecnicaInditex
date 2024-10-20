package com.pruebatecnicainditex.priceservice.aplication.service.implement;

import com.pruebatecnicainditex.priceservice.infrastructure.dto.PricesDto;
import com.pruebatecnicainditex.priceservice.infrastructure.dto.PricesDtoMapper;
import com.pruebatecnicainditex.priceservice.domain.model.Prices;
import com.pruebatecnicainditex.priceservice.domain.ports.PricesRepository;
import com.pruebatecnicainditex.priceservice.aplication.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PricesServicesImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Override
    public PricesDto getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        Optional<Prices> prices = pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, applicationDate, applicationDate);

        // Convierto la lista en un stream para filtrar por el campo prioridad y mostrar el precio con mayor prioridad.
        Prices mayorPriorityPrice = prices.stream()
                .max(Comparator.comparing(Prices::getPriority))
                .orElseThrow(() -> new IllegalArgumentException("No se han encontrado registros. Por favor, verifique los datos ingresados"));

        return PricesDtoMapper.toDto(mayorPriorityPrice);
    }

}

