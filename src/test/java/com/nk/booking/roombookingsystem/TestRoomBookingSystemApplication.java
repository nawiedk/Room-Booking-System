package com.nk.booking.roombookingsystem;

import org.springframework.boot.SpringApplication;

public class TestRoomBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.from(RoomBookingSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
