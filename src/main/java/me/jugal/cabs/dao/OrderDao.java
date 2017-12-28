package me.jugal.cabs.dao;

import me.jugal.cabs.dto.DriverDto;
import me.jugal.cabs.dto.OrderDto;
import me.jugal.cabs.entities.Driver;
import me.jugal.cabs.entities.Order;
import me.jugal.cabs.repositories.IDriverRepository;
import me.jugal.cabs.repositories.IOrderRepository;
import me.jugal.cabs.utils.DistanceUtil;
import me.jugal.cabs.utils.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDao implements IOrderDao {

    @Autowired
    private IOrderRepository orderRepo;

    @Autowired
    private IDriverRepository driverRepo;

    @Override
    @Transactional
    public OrderDto takeOrder(OrderDto orderDto) {
        List<Driver> availableDrivers = driverRepo.findByOrderNull();
        Order order = new Order();
        order.setLatitude(orderDto.getPosition().getLatitude());
        order.setLongitude(orderDto.getPosition().getLongitude());
        order.setCustomerName(orderDto.getCustomerName());
        orderRepo.save(order);
        Driver driver = findBestMatch(orderDto, availableDrivers);
        order.setDriver(driver);
        if (driver != null) {
            driver.setOrder(order);
            driverRepo.save(driver);
            orderDto.setDriver(new DriverDto(driver.getId(),
                    driver.getName(),
                    driver.getLatitude(),
                    driver.getLongitude(),
                    order.getCustomerName()));
        }
        orderDto.setId(order.getId());
        return orderDto;
    }

    private Driver findBestMatch(OrderDto orderDto, List<Driver> availableDrivers) {
        List<Position> options = availableDrivers.stream().map(
                driver -> new Position(driver.getLatitude(), driver.getLongitude())
        ).collect(Collectors.toList());
        int closestDriverIndex = DistanceUtil.findNearest(options, orderDto.getPosition());
        if (closestDriverIndex >= 0) {
            return availableDrivers.get(closestDriverIndex);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        driverRepo.freeAllDrivers();
        orderRepo.deleteAll();
    }
}
