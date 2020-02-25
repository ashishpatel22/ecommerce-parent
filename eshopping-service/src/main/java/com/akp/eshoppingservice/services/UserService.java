package com.akp.eshoppingservice.services;

import com.akp.eshoppingservice.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User findById(Long userId);

    public User add(User user);

    public void deleteById(Long id);
}
