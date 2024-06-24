package ivan.zver.kur.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ivan.zver.kur.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
