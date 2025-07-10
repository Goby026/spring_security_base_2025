package com.isekai.security.service;

import com.isekai.security.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserEntityService {

    private static final String EXISTING_EMAIL = "george@email.com";
    private static final String ANOTHER_EMAIL = "user@email.com";

    public Optional<UserEntity> findByEmail(String email) {

        //TODO: mover esto a una base de datos
        var user = new UserEntity();
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$Lde8m6v59Riuk8qJ.Rwgoudo4ThdGsuc6NyB5SKKI4o5oTdtAK7F."); //TODO:bcrypt (password)
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("Ingeniero");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            user.setId(2L);
            user.setEmail(ANOTHER_EMAIL);
            user.setPassword("$2a$12$Zi6K4urKP3kIS0OCvlTS4.Rcf0mxNbS4GHFD.7SlJP0LGEoFU6E7K"); //TODO:bcrypt (password2)
            user.setRole("ROLE_USER");
            user.setExtraInfo("PLEBEYO");
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
