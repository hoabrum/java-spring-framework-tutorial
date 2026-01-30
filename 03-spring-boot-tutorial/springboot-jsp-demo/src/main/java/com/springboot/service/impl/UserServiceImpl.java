package com.springboot.service.impl;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fetchUserDetails(Long id) {
        Optional<User> entityUser = userRepository.findById(id);
        if(entityUser.isPresent()) {
            return entityUser.get();
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return (userRepository.save(user) != null);
    }
}
