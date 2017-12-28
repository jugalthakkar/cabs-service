package me.jugal.cabs.dao;

import me.jugal.cabs.dto.DriverDto;

import java.util.List;

public interface IDriverDao {
    List<DriverDto> getAllDrivers();

    List<DriverDto> getAllAvailableDrivers();
}
