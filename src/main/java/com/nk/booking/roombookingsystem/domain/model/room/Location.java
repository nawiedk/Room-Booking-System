package com.nk.booking.roombookingsystem.domain.model.room;

import java.util.Objects;

public class Location {
    private final String building;
    private final String floor;

    public Location(String building, String floor) {
        this.building = Objects.requireNonNull(building);
        this.floor = Objects.requireNonNull(floor);
    }

    public String getBuilding() {
        return building;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return building.equals(location.building) && floor.equals(location.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, floor);
    }
}
