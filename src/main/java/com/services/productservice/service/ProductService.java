package com.services.productservice.service;

import com.services.productservice.dto.ProductRequest;
import com.services.productservice.dto.ProductResponse;
import com.services.productservice.model.Product;
import com.services.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    public final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product prod = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(prod);
    }

    public List<ProductResponse> listAll() {
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }
}
