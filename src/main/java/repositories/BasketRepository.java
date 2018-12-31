package repositories;

import models.Basket;
import models.Book;
import models.User;

import java.util.Optional;

public interface BasketRepository extends CrudRepository<Basket> {

    void addProductToBasket(Long basketId, Long bookId);
    void addUserId(Long id, Long userId);
    Optional<Basket> findOneByUserId(Long id);
    Optional<Basket> getBasketWithBooks(Long id);

}
