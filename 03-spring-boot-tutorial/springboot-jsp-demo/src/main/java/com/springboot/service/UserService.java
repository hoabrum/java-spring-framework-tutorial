package com.springboot.service;

import com.springboot.entity.User;

public interface UserService {

    User fetchUserDetails(Long id);

    boolean saveUser(User user);
}
