package com.coderhouse.model.database.document.concrete;

import com.coderhouse.model.database.document.ProductDocument;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@JsonTypeName("productTangible")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ProductTangible extends ProductDocument {

}
