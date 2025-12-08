package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.model.Product;

import java.util.UUID;

public interface ProductService {

    ProductListResponseDTO getAllProducts();

    ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException;

    ProductResponseDTO createProduct(ProductRequestDTO productRequest);

    Boolean deleteProduct(int id) throws ProductNotFoundException;

    Product updateProduct(int id);

    ProductResponseDTO getProductByTitle(String title);

    ProductResponseDTO getProductByTitleAndDescription(String title, String description);
}