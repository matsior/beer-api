package matsior.api.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import matsior.api.user.*;

@Data
public class RegistrationForm {

    private String username;
    private String email;
    private String password;
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,email,passwordEncoder.encode(password));
    }
}
