package com.coderhouse.model.database.document.concrete;

import com.coderhouse.model.database.document.ProductDocument;
import com.coderhouse.model.database.document.UserDocument;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@JsonTypeName("userEditor")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class UserEditor extends UserDocument {

}
