package com.scaler.EComProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository<Product> extends JpaRepository<Product, UUID> {

}