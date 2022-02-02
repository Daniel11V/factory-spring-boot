package com.coderhouse.service;

import com.coderhouse.model.request.ProductRequest;
import com.coderhouse.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);
    ProductResponse update(String id, ProductRequest request);
    List<ProductResponse> searchAll();
}
