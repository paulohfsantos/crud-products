package com.services.productservice.controller;

import com.services.productservice.dto.ProductRequest;
import com.services.productservice.dto.ProductResponse;
import com.services.productservice.model.Product;
import com.services.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest product) {
        try {
            productService.createProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> listProducts() {
        try {
            return productService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
