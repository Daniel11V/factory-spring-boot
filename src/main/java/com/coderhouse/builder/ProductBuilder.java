package com.coderhouse.builder;

import com.coderhouse.model.database.document.CategoryDocument;
import com.coderhouse.model.database.document.ProductDocument;
import com.coderhouse.model.database.document.concrete.ProductIntangible;
import com.coderhouse.model.database.document.concrete.ProductTangible;
import com.coderhouse.model.request.CategoryRequest;
import com.coderhouse.model.request.ProductRequest;
import com.coderhouse.model.response.CategoryResponse;
import com.coderhouse.model.response.ProductResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    public static ProductTangible requestToEntityTangible(ProductRequest request) {
        return ProductTangible.builder()
                .type(request.getType())
                .price(request.getPrice())
                .category(requestToEntityCategory(request.getCategory()))
                .createDate(LocalDateTime.now())
                .status(Boolean.TRUE)
                .description(request.getDescription())
                .build();
    }

    public static ProductIntangible requestToEntityIntangible(ProductRequest request) {
        return ProductIntangible.builder()
                .type(request.getType())
                .price(request.getPrice())
                .serviceTime(request.getServiceTime())
                .category(requestToEntityCategory(request.getCategory()))
                .status(Boolean.TRUE)
                .createDate(LocalDateTime.now())
                .description(request.getDescription())
                .build();
    }

    private static CategoryDocument requestToEntityCategory(CategoryRequest category) {
        return CategoryDocument.builder().description(category.getDescription()).build();
    }

    public static ProductResponse entityToResponseCreate(ProductDocument entity) {
        return ProductResponse.builder()
                .code(entity.getId())
                .createDate(entity.getCreateDate().toString())
                .status(entity.isStatus())
                .build();
    }


    public static <T extends ProductDocument> ProductResponse entityToResponse(T entity) {
        if (entity instanceof ProductIntangible) {
            var entityCast = (ProductIntangible) entity;
            return ProductResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .serviceTime(entityCast.getServiceTime())
                    .category(buildCategory(entity.getCategory()))
                    .description(entity.getDescription())
                    .price(entity.getPrice())
                    .type(entity.getType())
                    .build();
        } else {
            return ProductResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .category(buildCategory(entity.getCategory()))
                    .description(entity.getDescription())
                    .price(entity.getPrice())
                    .type(entity.getType())
                    .build();
        }
    }

    private static CategoryResponse buildCategory(CategoryDocument category) {
        return CategoryResponse.builder().description(category.getDescription()).build();
    }

    public static List<ProductResponse>
    listEntityToResponse(List<ProductDocument> products) {

        var listResponse = new ArrayList<ProductResponse>();
        products.forEach(item -> listResponse.add(entityToResponse(item)));
        return listResponse;
    }

}
