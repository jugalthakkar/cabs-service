package me.jugal.loginext.dto;

import me.jugal.loginext.utils.Position;

import java.io.Serializable;

public class OrderDto implements Serializable {
    private int id;
    private String customerName;
    private Position position;
    private DriverDto driver;

    public OrderDto(String customerName, float latitude, float longitude) {
        this.customerName = customerName;
        this.position = new Position(latitude, longitude);
    }

    public OrderDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
