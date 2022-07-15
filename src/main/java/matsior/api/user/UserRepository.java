package matsior.api.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
