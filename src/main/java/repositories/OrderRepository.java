package repositories;

import models.Book;
import models.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {
     void findAllBooks(Long id);
     void saveOrder(List<Book> bookList, Order order);
}

