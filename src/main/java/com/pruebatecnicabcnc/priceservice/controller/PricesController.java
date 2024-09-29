package com.pruebatecnicabcnc.priceservice.controller;

import com.pruebatecnicabcnc.priceservice.dto.PricesDto;
import com.pruebatecnicabcnc.priceservice.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("v1/api/prices")
@RequiredArgsConstructor
public class PricesController {

    private final PricesService pricesService;


    @GetMapping
    public ResponseEntity<PricesDto> getPrice(@RequestParam String applicationDate,
                                              @RequestParam Integer productId,
                                              @RequestParam Integer brandId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(applicationDate, formatter);
        PricesDto price = pricesService.getPrice(date, productId, brandId);

        return ResponseEntity.ok(price);

    }
}
