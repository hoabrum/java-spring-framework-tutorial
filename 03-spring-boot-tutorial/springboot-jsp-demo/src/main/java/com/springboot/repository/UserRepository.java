package com.springboot.repository;

import com.springboot.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //SELECT * FROM users WHERE email = ? and password = ?
    User findByEmailAndPassword(String email, String password);
}
