package me.jugal.cabs.dto;

import me.jugal.cabs.utils.Position;

import java.io.Serializable;

public class DriverDto implements Serializable {
    private String name;
    private int id;
    private Position position;
    private String customerName;

    public DriverDto(int id, String name, float latitude, float longitude, String customerName) {
        this.name = name;
        this.id = id;
        this.position = new Position(latitude, longitude);
        this.customerName = customerName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public String getCustomerName() {
        return customerName;
    }
}
