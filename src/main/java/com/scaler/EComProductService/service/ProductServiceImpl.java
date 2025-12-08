package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.mapper.ProductMapper;
import com.scaler.EComProductService.model.Product;
import com.scaler.EComProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.scaler.EComProductService.util.ProductUtils.isNull;

@Service("NormalProductService")
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productResponseDTO = ProductMapper.convertProductsToProductResponseDTO(products);
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {
        Optional<Product> product= productRepository.findById(id);
        if(isNull(product)){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product.get());
        return productResponseDTO;
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

    @Override
    public ProductResponseDTO getProductByTitle(String title) {

        Product product = (Product) productRepository.findByTitle(title);

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    public ProductResponseDTO getProductByTitleAndDescription(String title, String description)
    {
        Product product = (Product) productRepository.findByTitleAndDescription(title, description);

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }
}
