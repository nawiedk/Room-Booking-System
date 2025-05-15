package com.nk.booking.roombookingsystem.domain.model.room;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void roomShouldBeCreatedWithValidData() {
        UUID id = UUID.randomUUID();
        Location location = new Location("Building A", "2nd Floor");
        Set<Feature> features = EnumSet.of(Feature.WHITEBOARD, Feature.PROJECTOR);

        Room room = new Room(id, "A101", 12, location, features);

        assertEquals(id, room.getId());
        assertEquals("A101", room.getCode());
        assertEquals(12, room.getCapacity());
        assertEquals(location, room.getLocation());
        assertEquals(features, room.getFeatures());
    }

    @Test
    void roomShouldContainRequestedFeature() {
        Room room = new Room(
                UUID.randomUUID(),
                "B202",
                8,
                new Location("Building B", "1st Floor"),
                EnumSet.of(Feature.VIDEO_CONFERENCING, Feature.AIR_CONDITIONING)
        );

        assertTrue(room.hasFeature(Feature.VIDEO_CONFERENCING));
        assertFalse(room.hasFeature(Feature.PROJECTOR));
    }

    @Test
    void creatingRoomWithInvalidCapacityShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Room(
                    UUID.randomUUID(),
                    "X999",
                    0,
                    new Location("C", "3"),
                    EnumSet.of(Feature.PROJECTOR)
            );
        });
    }

    @Test
    void creatingRoomWithNullValuesShouldThrow() {
        UUID id = UUID.randomUUID();
        Location location = new Location("Main", "Ground");

        assertThrows(NullPointerException.class, () ->
                new Room(null, "X", 10, location, EnumSet.of(Feature.WHITEBOARD)));

        assertThrows(NullPointerException.class, () ->
                new Room(id, null, 10, location, EnumSet.of(Feature.WHITEBOARD)));

        assertThrows(NullPointerException.class, () ->
                new Room(id, "X", 10, null, EnumSet.of(Feature.WHITEBOARD)));

        assertThrows(NullPointerException.class, () ->
                new Room(id, "X", 10, location, null));
    }
}
