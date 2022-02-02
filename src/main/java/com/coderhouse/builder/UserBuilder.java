package com.coderhouse.builder;

import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.database.document.concrete.UserAdmin;
import com.coderhouse.model.database.document.concrete.UserClient;
import com.coderhouse.model.database.document.concrete.UserEditor;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    public static UserAdmin requestToEntityAdmin(UserRequest request) {
        return UserAdmin.builder()
                .type(request.getType())
                .numberReadings(request.getNumberReadings())
                .serviceTime(request.getServiceTime())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }

    public static UserEditor requestToEntityEditor(UserRequest request) {
        return UserEditor.builder()
                .type(request.getType())
                .numberReadings(request.getNumberReadings())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }

    public static UserClient requestToEntityClient(UserRequest request) {
        return UserClient.builder()
                .type(request.getType())
                .numberReadings(request.getNumberReadings())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }

    public static UserResponse entityToResponseCreate(UserDocument entity) {
        return UserResponse.builder()
                .code(entity.getId())
                .createDate(entity.getCreateDate().toString())
                .status(entity.isStatus())
                .build();
    }


    public static <T extends UserDocument> UserResponse entityToResponse(T entity) {
        if (entity instanceof UserAdmin) {
            var entityCast = (UserAdmin) entity;
            return UserResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .serviceTime(entityCast.getServiceTime())
                    .name(entity.getName())
                    .numberReadings(entity.getNumberReadings())
                    .type(entity.getType())
                    .build();
        } else {
            return UserResponse.builder()
                    .code(entity.getId())
                    .status(entity.isStatus())
                    .createDate(entity.getCreateDate().toString())
                    .name(entity.getName())
                    .numberReadings(entity.getNumberReadings())
                    .type(entity.getType())
                    .build();
        }
    }

    public static List<UserResponse>
    listEntityToResponse(List<UserDocument> users) {

        var listResponse = new ArrayList<UserResponse>();
        users.forEach(user -> listResponse.add(entityToResponse(user)));
        return listResponse;
    }

}
