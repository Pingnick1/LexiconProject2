package se.coconutflightbooking.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;



class AirPlaneTest {

    @Test
    @DisplayName("getAirPlaneID")
    void getAirPlaneID() {
        AirPlane plane1 = new AirPlane("CC001", 5, 5, AirPlaneStatus.HANGAR);

        Assertions.assertTrue("CC001".equals(plane1.getAirPlaneID()));



        //assertEquals(true);

        //Assertions.assertEquals("CC001".equals(plane1.getAirPlaneID()));
    }

    @Test
    void setAirPlaneID() {
    }

    @Test
    void getNrOfEconomcSeats() {
    }

    @Test
    void setNrOfEconomcSeats() {
    }

    @Test
    void getNrOfFirstClass() {
    }

    @Test
    void setNrOfFirstClass() {
    }

    @Test
    void getAirPlaneStatus() {
    }

    @Test
    void setAirPlaneStatus() {
    }

    @Test
    void equals() {
    }
}