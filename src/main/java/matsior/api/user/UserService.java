package matsior.api.user;

import matsior.api.user.dto.UserSaveRequest;

import java.util.List;
import java.util.Optional;

interface UserService {
    List<User> getUsers();
    Optional<User> findUserById(Long id);
    User saveUser(UserSaveRequest userSaveRequest);
}
