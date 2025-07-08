package com.isekai.security.service;

import com.isekai.security.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService {

    private static final String EXISTING_EMAIL = "test@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        //TODO: mover esto a una base de datos
        if (! EXISTING_EMAIL.equalsIgnoreCase(email)) return Optional.empty();

        var user = new UserEntity();
        user.setId(1L);
        user.setEmail("george@email.com");
        user.setPassword("$2a$12$Lde8m6v59Riuk8qJ.Rwgoudo4ThdGsuc6NyB5SKKI4o5oTdtAK7F."); //TODO:bcrypt (password)
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("Ingeniero");

        return Optional.of(user);
    }
}
