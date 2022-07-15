package matsior.api.user;

import matsior.api.user.dto.UserFullResponse;
import matsior.api.user.dto.UserSaveRequest;

import java.util.List;
import java.util.Optional;

interface UserService {
    List<UserFullResponse> getUsers();
    Optional<UserFullResponse> findUserById(Long id);
    UserFullResponse saveUser(UserSaveRequest userSaveRequest);
    void deleteUser(Long id);
}
