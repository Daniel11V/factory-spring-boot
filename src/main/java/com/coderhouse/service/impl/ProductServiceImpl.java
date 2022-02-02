package com.coderhouse.service.impl;

import com.coderhouse.builder.ProductBuilder;
import com.coderhouse.model.ProductFactory;
import com.coderhouse.model.request.ProductRequest;
import com.coderhouse.model.response.ProductResponse;
import com.coderhouse.repository.ProductRepository;
import com.coderhouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductFactory productFactory = new ProductFactory();

    @Override
    public ProductResponse create(ProductRequest request) {
        var entity =
                productFactory.createProduct(request);
        var entitySaved = repository.save(entity);
        return ProductBuilder.entityToResponseCreate(entitySaved);
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        var entity =
                productFactory.createProduct(request);
        entity.setId(id);
        var entitySaved = repository.save(entity);
        return ProductBuilder.entityToResponseCreate(entitySaved);
    }

    @Override
    public List<ProductResponse> searchAll() {
        return ProductBuilder.listEntityToResponse(repository.findAll());
    }
}
