package com.pruebatecnicabcnc.priceservice.repository;

import com.pruebatecnicabcnc.priceservice.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
}
