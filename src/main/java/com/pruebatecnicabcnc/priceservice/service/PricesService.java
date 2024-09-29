package com.pruebatecnicabcnc.priceservice.service;

import com.pruebatecnicabcnc.priceservice.dto.PricesDto;
import com.pruebatecnicabcnc.priceservice.model.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

    PricesDto getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
