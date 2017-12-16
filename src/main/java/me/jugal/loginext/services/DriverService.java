package me.jugal.loginext.services;

import me.jugal.loginext.dao.DriverDao;
import me.jugal.loginext.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverService {

    @Autowired
    private DriverDao driverDao;

    @RequestMapping("/")
    public List<DriverDto> getDrivers() {
        return driverDao.getAllDrivers();
    }

}
