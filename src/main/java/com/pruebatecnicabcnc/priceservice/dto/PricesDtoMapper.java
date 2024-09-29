package com.pruebatecnicabcnc.priceservice.dto;

import com.pruebatecnicabcnc.priceservice.model.Prices;

public class PricesDtoMapper {
    public static PricesDto toDto(Prices prices) {

            PricesDto pricesDto = new PricesDto();

                pricesDto.setProductId(prices.getProductId());
                pricesDto.setBrandId(prices.getBrandId());
                pricesDto.setPriceList(prices.getPriceList());
                pricesDto.setStartDate(prices.getStartDate());
                pricesDto.setEndDate(prices.getEndDate());
                pricesDto.setPrice(prices.getPrice());

            return pricesDto;
    }
}
