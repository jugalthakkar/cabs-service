package me.jugal.cabs.dao;

import me.jugal.cabs.dto.DriverDto;
import me.jugal.cabs.entities.Driver;
import me.jugal.cabs.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverDao implements IDriverDao {

    @Autowired
    private IDriverRepository driverRepo;

    @Override
    public List<DriverDto> getAllDrivers() {
        return getDriverDTOs(driverRepo.findAll());
    }

    @Override
    public List<DriverDto> getAllAvailableDrivers() {
        return getDriverDTOs(driverRepo.findByOrderNull());
    }

    private List<DriverDto> getDriverDTOs(Iterable<Driver> driverEntities) {
        ArrayList<DriverDto> drivers = new ArrayList<>();
        driverEntities.forEach(
                driverEntity -> drivers.add(
                        new DriverDto(driverEntity.getId(),
                                driverEntity.getName(),
                                driverEntity.getLatitude(),
                                driverEntity.getLongitude(),
                                driverEntity.getOrder() != null ? driverEntity.getOrder().getCustomerName() : null))
        );
        return drivers;
    }

}

