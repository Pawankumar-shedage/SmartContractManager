package com.scm.scm20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.scm20.entities.User;

public interface UserRepo extends JpaRepository<User,String>{


    //db queries.
}
