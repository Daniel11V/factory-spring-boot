package com.coderhouse.service.impl;

import com.coderhouse.builder.UserBuilder;
import com.coderhouse.cache.CacheClient;
import com.coderhouse.handle.ApiRestException;
import com.coderhouse.model.UserFactory;
import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();
    private final CacheClient<UserDocument> cache;

    @Override
    public UserResponse create(UserRequest request) {
        var entity = userFactory.createUser(request);
        try {
            var entitySaved = repository.save(entity);
            saveUserInCache(entitySaved);
            return UserBuilder.entityToResponseCreate(entitySaved);
        } catch (JsonProcessingException e) {
            log.error("Error converting user to string", e);
        }
        return UserBuilder.entityToResponseCreate(entity);
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        var entity = userFactory.createUser(request);
        entity.setId(id);
        try {
            saveUserInCache(entity);
            var entitySaved = repository.save(entity);
            return UserBuilder.entityToResponseCreate(entitySaved);
        } catch (JsonProcessingException e) {
            log.error("Error converting restaurante to string", e);
        }
        return UserBuilder.entityToResponseCreate(entity);
    }

    @Override
    public List<UserResponse> searchAll() {
        return UserBuilder.listEntityToResponse(repository.findAll());
    }

    @Override
    public UserResponse searchById(String id) {
        try {
            if (id.equals("0")) {
                throw ApiRestException.builder().message("El identificador del user debe ser mayor a 0").build();
            }
            var dataFromCache = cache.recover(id, UserDocument.class);
            if (!Objects.isNull(dataFromCache)) {
                log.info("Respuesta obtenida de Redis");
                return UserBuilder.entityToResponse(dataFromCache);
            }
            log.info("Respuesta NO obtenida de Redis");
            var dataFromDatabase = repository.findById(id).orElseThrow(ApiRestException::new);
            saveUserInCache(dataFromDatabase);
            return UserBuilder.entityToResponse(dataFromDatabase);
        } catch (JsonProcessingException e) {
            log.error("Error converting user to string", e);
        } catch (ApiRestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveUserInCache(UserDocument user) throws JsonProcessingException {
        log.info("Guardado en Redis: {}", user);
        cache.save(user.getId(), user);
    }
}
