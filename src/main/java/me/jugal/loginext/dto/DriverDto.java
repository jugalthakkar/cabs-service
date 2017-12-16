package me.jugal.loginext.dto;

import me.jugal.loginext.utils.Position;

import java.io.Serializable;

public class DriverDto implements Serializable {
    private String name;
    private int id;
    private Position position;
    private Boolean busy;

    public DriverDto(int id, String name, float latitude, float longitude, Boolean busy) {
        this.name = name;
        this.id = id;
        this.position = new Position(latitude, longitude);
        this.busy = busy;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Boolean getBusy() {
        return busy;
    }

    public Position getPosition() {
        return position;
    }
}
