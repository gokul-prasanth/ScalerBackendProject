package com.scaler.EComProductService.service;

import com.scaler.EComProductService.client.FakeStoreAPIClient;
import com.scaler.EComProductService.dto.*;
import com.scaler.EComProductService.exception.ProductNotFoundException;
import com.scaler.EComProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static com.scaler.EComProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.EComProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EComProductService.util.ProductUtils.isNull;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder; //This is the part of the Spring web dependency

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,
                                   FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient; // Creating the object of FakeStoreAPIClient
    }
    @Override
    public ProductListResponseDTO getAllProducts() {
        String productResponseList = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build(); // Build the object that will be interacting with the web and supporting http methods like GET, PUT, POST etc
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOs = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOs)
        {
            productListResponseDTO.getProduct()
                    .add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }

        return productListResponseDTO;

        /* This code is we were directly getting the ProductListResponseDTO */
       /*
        ResponseEntity<ProductResponseDTO[]> productResponseArray; // We are also returning Array Type from getFor
        productResponseArray = restTemplate.getForEntity(productResponseList,ProductResponseDTO[].class); // we use .class to tell the JVM that we are receiving the response of ProductResponseDTO class(class type). JVM cannot figure that out on it's own

        ProductListResponseDTO responseDTO = new  ProductListResponseDTO();
       // This is mapper
        for(ProductResponseDTO productResponse : Objects.requireNonNull(productResponseArray.getBody()))
        {
            responseDTO.getProduct().add(productResponse);// As we create productResponse object, it will initialize the List type attribute product. We are initializing it to type Array in that class. And we get that product attribute by getProducts(). Then add the elements to it
        }
        return responseDTO;*/

    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException {

        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequest)
    {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequest);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    public Boolean deleteProduct(int id)  throws ProductNotFoundException {

        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }
    @Override
    public Product updateProduct(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) {
        return null;
    }

    @Override
    public ProductResponseDTO getProductByTitleAndDescription(String title, String description) {
        return null;
    }
}
