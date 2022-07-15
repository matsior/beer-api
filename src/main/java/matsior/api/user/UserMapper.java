package matsior.api.user;

import matsior.api.user.dto.UserSaveRequest;
import org.springframework.stereotype.Service;

@Service
class UserMapper {

    public User map(UserSaveRequest userSaveRequest) {
        return new User(
                userSaveRequest.username(),
                userSaveRequest.email(),
                userSaveRequest.password()
        );
    }
}
