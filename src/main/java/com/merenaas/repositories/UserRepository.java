package com.merenaas.repositories;

import com.merenaas.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
    User findOneByLogin(String login);
    User findOneByPhoneNumber(String phoneNumber);
}
