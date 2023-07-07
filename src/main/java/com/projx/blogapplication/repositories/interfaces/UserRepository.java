package com.projx.blogapplication.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projx.blogapplication.models.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmailIgnoreCase(String email);

    boolean existsUserByUsernameIgnoreCase(String username);

    @Query("select u from User u where lower(u.username) =:username or lower(u.email)=:username ")
    Optional<User> findUserByUsernameIgnoreCaseOrEmailIgnoreCase(String username);
}
