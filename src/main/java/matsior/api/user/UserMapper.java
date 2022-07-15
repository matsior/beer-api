package matsior.api.user;

import matsior.api.user.dto.UserFullResponse;
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

    public UserFullResponse map(User user) {
        return new UserFullResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCreated()
        );
    }

    public User map(Long id, UserSaveRequest userSaveRequest) {
        return new User(
                id,
                userSaveRequest.username(),
                userSaveRequest.email(),
                userSaveRequest.password()
        );
    }
}
