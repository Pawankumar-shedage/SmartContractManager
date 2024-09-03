package com.scm.scm20.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scm.scm20.entities.User;

public interface UserRepo extends JpaRepository<User,String>{

    // JpaRepository<Entity,Id data_type of primary_key>

    //db queries.

    // findingUser By EmailId: Jpa generates Query automatically with help of pattern "findByEmail" - findBy ->ColumnName/FieldName. FieldName must be in camelCase
    Optional<User> findByEmail(String email);

    // Custom
    // @Query(value="SELECT * FROM User WHERE email = :email",nativeQuery = true)
    // User findByEmail(String email);
}
