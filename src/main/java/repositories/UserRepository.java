package repositories;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByLogin(String login);
    void addBasketId(Long id, Long basketId);
}
