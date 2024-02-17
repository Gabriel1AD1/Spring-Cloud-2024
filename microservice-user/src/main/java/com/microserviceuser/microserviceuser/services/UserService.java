package com.microserviceuser.microserviceuser.services;

import com.microserviceuser.microserviceuser.models.entitys.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> listAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    Optional<User> findByEmail(String email);
    Boolean existByEmail(String Email);

    List<User> listById(Iterable<Long> id);
}
