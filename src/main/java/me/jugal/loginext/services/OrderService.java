package me.jugal.loginext.services;

import me.jugal.loginext.dao.OrderDao;
import me.jugal.loginext.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public OrderDto takeOrder(@RequestBody OrderDto orderDto) {

        return orderDao.takeOrder(orderDto);
    }
}
