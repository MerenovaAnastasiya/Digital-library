package com.merenaas.repositories;

import com.merenaas.models.Book;
import com.merenaas.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Long> {

}

