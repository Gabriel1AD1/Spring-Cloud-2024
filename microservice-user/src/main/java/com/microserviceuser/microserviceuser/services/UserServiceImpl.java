package com.microserviceuser.microserviceuser.services;

import com.microserviceuser.microserviceuser.models.entitys.User;
import com.microserviceuser.microserviceuser.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Boolean existByEmail(String Email) {
        return repository.existsByEmail(Email);
    }

    @Override
    public List<User> listById(Iterable<Long> id) {
        return (List<User>) repository.findAllById(id);
    }


}
