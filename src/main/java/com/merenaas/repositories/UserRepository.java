package com.merenaas.repositories;

import com.merenaas.models.Basket;
import com.merenaas.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
    User findOneByLogin(String login);
}
