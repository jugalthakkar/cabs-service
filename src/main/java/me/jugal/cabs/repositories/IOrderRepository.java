package me.jugal.cabs.repositories;

import me.jugal.cabs.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<Order, Integer> {
}