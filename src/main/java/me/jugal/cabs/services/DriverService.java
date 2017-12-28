package me.jugal.cabs.services;

import me.jugal.cabs.dao.IDriverDao;
import me.jugal.cabs.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/drivers")
public class DriverService {

    @Autowired
    private IDriverDao driverDao;

    @RequestMapping("/")
    public List<DriverDto> getDrivers() {
        return driverDao.getAllDrivers();
    }

    @RequestMapping("/available")
    public List<DriverDto> getAllAvailableDrivers() {
        return driverDao.getAllAvailableDrivers();
    }

}
