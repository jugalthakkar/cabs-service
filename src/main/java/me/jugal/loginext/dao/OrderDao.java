package me.jugal.loginext.dao;

import me.jugal.loginext.dto.DriverDto;
import me.jugal.loginext.dto.OrderDto;
import me.jugal.loginext.entities.Driver;
import me.jugal.loginext.entities.Order;
import me.jugal.loginext.repositories.DriverRepository;
import me.jugal.loginext.repositories.OrderRepository;
import me.jugal.loginext.utils.DistanceUtil;
import me.jugal.loginext.utils.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDao {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private DriverRepository driverRepo;

    public OrderDto takeOrder(OrderDto orderDto) {
        List<Driver> availableDrivers = driverRepo.findByBusyFalse();
        Order order = new Order();
        order.setActive(true);
        order.setLatitude(orderDto.getPosition().getLatitude());
        order.setLongitude(orderDto.getPosition().getLongitude());
        order.setCustomerName(orderDto.getCustomerName());
        Driver driver = findBestMatch(orderDto, availableDrivers);
        order.setDriver(driver);
        if (driver != null) {
            driver.setBusy(true);
            driverRepo.save(driver);
            orderDto.setDriver(new DriverDto(driver.getId(),
                    driver.getName(),
                    driver.getLatitude(),
                    driver.getLongitude(),
                    driver.isBusy()));
        }
        orderRepo.save(order);
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
}
