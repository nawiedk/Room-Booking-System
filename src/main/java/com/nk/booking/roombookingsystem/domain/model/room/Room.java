package com.nk.booking.roombookingsystem.domain.model.room;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Room {
    private final UUID id;
    private final String code;
    private final int capacity;
    private final Location location;
    private final Set<Feature> features;

    public Room(UUID id, String code, int capacity, Location location, Set<Feature> features) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Room capacity must be greater than 0.");
        }
        this.id = Objects.requireNonNull(id);
        this.code = Objects.requireNonNull(code);
        this.capacity = capacity;
        this.location = Objects.requireNonNull(location);
        this.features = Objects.requireNonNull(features);
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public Location getLocation() {
        return location;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public boolean hasFeature(Feature feature) {
        return features.contains(feature);
    }
}
