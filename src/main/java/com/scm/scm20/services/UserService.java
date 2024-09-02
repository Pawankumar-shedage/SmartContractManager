package com.scm.scm20.services;

import java.util.List;
import java.util.Optional;

import com.scm.scm20.entities.User;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean doesUserExist(String userId);
    boolean doesUserExistByEmail(String email);
    List<User> getAllUsers();

    // methods user services[biz-logic].
}
