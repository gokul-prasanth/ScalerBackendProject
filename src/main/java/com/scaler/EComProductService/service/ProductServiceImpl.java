package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.model.Product;
import org.springframework.stereotype.Service;

@Service("NormalProductService")
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequest) {
        return null;
    }
    @Override
    public Boolean deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id) {
        return null;
    }
}
