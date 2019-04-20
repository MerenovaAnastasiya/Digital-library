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
public interface BasketRepository extends CrudRepository<Basket, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Basket SET " +
            "user = :user " +
            "WHERE id = :id")
    void setUserToBasket(@Param("user") User user,
                        @Param("id") Long id);

//    void addProductToBasket(Long basketId, Long bookId);
////    void addUserId(Long id, Long userId);

}
