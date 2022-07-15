package matsior.api.user;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User findUserById(Long id);
    User saveUser(User user);
}
