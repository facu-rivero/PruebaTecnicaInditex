package com.pruebatecnicainditex.priceservice.aplication.service;

import com.pruebatecnicainditex.priceservice.infrastructure.dto.PricesDto;

import java.time.LocalDateTime;


public interface PricesService {

    PricesDto getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
