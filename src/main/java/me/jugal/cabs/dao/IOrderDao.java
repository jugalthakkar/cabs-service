package me.jugal.cabs.dao;

import me.jugal.cabs.dto.OrderDto;

public interface IOrderDao {
    OrderDto takeOrder(OrderDto orderDto);

    void deleteAll();
}
