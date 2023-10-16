package com.moratodev.todolist.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    void deleteById(UUID id);
    void deleteByUsername(String username);
}