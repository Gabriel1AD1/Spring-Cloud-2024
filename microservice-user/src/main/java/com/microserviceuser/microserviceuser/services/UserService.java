package com.microserviceuser.microserviceuser.repository;

import com.microserviceuser.microserviceuser.models.entitys.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAll();

    Optional<User> findById(Long id);

    User save(User user);

    void eliminar(Long id);



}
