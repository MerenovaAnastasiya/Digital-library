package com.merenaas.repositories;

import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO digital_library.public.basket_book (basket_id, book_id) VALUES (:id, :bookId)",
            nativeQuery = true)
    void addBookToBasket(@Param("id") Long id, @Param("bookId")Long bookId);

}
