package matsior.api.user;

import lombok.RequiredArgsConstructor;
import matsior.api.user.dto.UserSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(UserSaveRequest userSaveRequest) {
        User userToSave = userMapper.map(userSaveRequest);
        return userRepository.save(userToSave);
    }
}
