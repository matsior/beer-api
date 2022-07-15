package matsior.api.user;

import lombok.RequiredArgsConstructor;
import matsior.api.exceptionhandling.exception.EmailTakenException;
import matsior.api.exceptionhandling.exception.UserNameTakenException;
import matsior.api.user.dto.UserFullResponse;
import matsior.api.user.dto.UserSaveRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameAlreadyBoundException;
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
        if (userRepository.existsByUsername(userSaveRequest.username())) {
            throw new UserNameTakenException(userSaveRequest.username());
        }
        if (userRepository.existsByEmail(userSaveRequest.email())) {
            throw new EmailTakenException(userSaveRequest.email());
        }
        User userToSave = userMapper.map(userSaveRequest);
        User savedUser = userRepository.save(userToSave);
        return userMapper.map(savedUser);
    }

    @Override
    public Optional<UserFullResponse> replaceUser(Long id, UserSaveRequest userSaveRequest) {
        if (!userRepository.existsById(id)) {
            return Optional.empty();
        }
        User userToUpdate = userMapper.map(id, userSaveRequest);
        User updatedUser = userRepository.save(userToUpdate);
        return Optional.of(userMapper.map(updatedUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
