package me.jugal.cabs.services;

import me.jugal.cabs.dao.IOrderDao;
import me.jugal.cabs.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderService {

    @Autowired
    private IOrderDao IOrderDao;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public OrderDto takeOrder(@RequestBody OrderDto orderDto) {

        return IOrderDao.takeOrder(orderDto);
    }

    @Transactional
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAllOrders() {
        IOrderDao.deleteAll();
    }

}
