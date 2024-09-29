package com.pruebatecnicabcnc.priceservice.service.implement;

import com.pruebatecnicabcnc.priceservice.dto.PricesDto;
import com.pruebatecnicabcnc.priceservice.dto.PricesDtoMapper;
import com.pruebatecnicabcnc.priceservice.model.Prices;
import com.pruebatecnicabcnc.priceservice.repository.PricesRepository;
import com.pruebatecnicabcnc.priceservice.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesServicesImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Override
    public PricesDto getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        List<Prices> prices = pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, applicationDate, applicationDate);

        // Convierto la lista en un stream para filtrar por el campo prioridad y mostrar el precio con mayor prioridad.
        Prices mayorPriorityPrice = prices.stream()
                .max(Comparator.comparing(Prices::getPriority))
                .orElseThrow(() -> new IllegalArgumentException("No se han encontrado registros. Por favor, verifique los datos ingresados"));

        return PricesDtoMapper.toDto(mayorPriorityPrice);
    }

}

