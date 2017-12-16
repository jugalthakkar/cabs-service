package me.jugal.loginext.repositories;

import me.jugal.loginext.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}