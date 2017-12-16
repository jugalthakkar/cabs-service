package me.jugal.loginext.dao;

import me.jugal.loginext.dto.DriverDto;
import me.jugal.loginext.entities.Driver;
import me.jugal.loginext.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverDao {

    @Autowired
    private DriverRepository driversRepo;

    public List<DriverDto> getAllDrivers() {
        return getDriverDTOs(driversRepo.findAll());
    }

    private List<DriverDto> getDriverDTOs(Iterable<Driver> driverEntities) {
        ArrayList<DriverDto> drivers = new ArrayList<>();
        driverEntities.forEach(
                driverEntity -> drivers.add(
                        new DriverDto(driverEntity.getId(),
                                driverEntity.getName(),
                                driverEntity.getLatitude(),
                                driverEntity.getLongitude(),
                                driverEntity.isBusy()))
        );
        return drivers;
    }


}

