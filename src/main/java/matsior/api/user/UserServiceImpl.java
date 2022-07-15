package matsior.api.user;

import lombok.RequiredArgsConstructor;
import matsior.api.user.dto.UserFullResponse;
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
    public List<UserFullResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .toList();
    }

    @Override
    public Optional<UserFullResponse> findUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::map);
    }

    @Override
    public UserFullResponse saveUser(UserSaveRequest userSaveRequest) {
        User userToSave = userMapper.map(userSaveRequest);
        User savedUser = userRepository.save(userToSave);
        return userMapper.map(savedUser);
    }
}
