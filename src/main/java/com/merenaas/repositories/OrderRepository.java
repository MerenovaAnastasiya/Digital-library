package com.merenaas.repositories;

import com.merenaas.models.Book;
import com.merenaas.models.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {
     void saveOrder(List<Book> bookList, Order order);
}

