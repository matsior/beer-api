package matsior.api.user;

import java.util.List;
import java.util.Optional;

interface UserService {
    List<User> getUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
}
