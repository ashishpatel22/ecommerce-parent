package com.akp.eshoppingservice.services;

import com.akp.eshoppingservice.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Optional<User> findById(Long userId);

    public User add(User user);

    public void deleteById(Long id);
}
