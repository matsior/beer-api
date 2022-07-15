package matsior.api.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
