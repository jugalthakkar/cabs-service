package me.jugal.loginext.repositories;

import me.jugal.loginext.entities.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Integer> {
    List<Driver> findByBusyFalse();
}
