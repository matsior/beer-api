package matsior.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    @Override
    public User saveUser(User user) {
        throw new IllegalArgumentException("Not implemented yet");
    }
}
