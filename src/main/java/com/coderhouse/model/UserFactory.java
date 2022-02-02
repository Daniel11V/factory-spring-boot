package com.coderhouse.model;

import com.coderhouse.builder.UserBuilder;
import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.request.UserRequest;
import lombok.Data;

@Data
public class UserFactory {

    public UserDocument createUser(UserRequest request) {
        switch (request.getType()) {
            case "ADMIN":
                return UserBuilder.requestToEntityAdmin(request);
            case "EDITOR":
                return UserBuilder.requestToEntityEditor(request);
            case "CLIENT":
                return UserBuilder.requestToEntityClient(request);
            default:
                return null;
        }
    }

}
