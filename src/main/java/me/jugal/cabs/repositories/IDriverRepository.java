package me.jugal.cabs.repositories;

import me.jugal.cabs.entities.Driver;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDriverRepository extends CrudRepository<Driver, Integer> {
    List<Driver> findByOrderNull();

    @Modifying
    @Query("update Driver d set d.order = null")
    void freeAllDrivers();
}
