package se.coconutflightbooking.tests;

import org.junit.jupiter.api.Test;
import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneListHandler;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.exceptions.AirPlaneNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AirPlaneListHandlerTest {

    @org.junit.jupiter.api.Test
    void getOurAirPlaneList() {
    }

    @Test
    void setOurAirPlaneList() {
    }

    @Test
    void getAirPlane() {
        AirPlane plane1 = new AirPlane("CCC00001", 5, 5, AirPlaneStatus.HANGAR);
        AirPlane plane2 = new AirPlane("CCC00002", 10, 5, AirPlaneStatus.HANGAR);
        AirPlane plane3 = new AirPlane("CCC00003", 6, 4, AirPlaneStatus.HANGAR);
        AirPlane plane4 = new AirPlane("CCC00004", 1, 9, AirPlaneStatus.HANGAR);
        AirPlane plane5 = new AirPlane("CCC00005", 20, 10, AirPlaneStatus.HANGAR);

        AirPlaneListHandler airPlaneList = new AirPlaneListHandler();

        //Lägg till nya fygplan i listan
        assertTrue(airPlaneList.addAirPlane(plane1));
        assertTrue(airPlaneList.addAirPlane(plane2));
        assertTrue(airPlaneList.addAirPlane(plane3));
        assertTrue(airPlaneList.addAirPlane(plane4));
        assertTrue(airPlaneList.addAirPlane(plane5));

        try {
            AirPlane result = airPlaneList.getAirPlane("CCC00003");
            System.out.println(result);
        } catch (AirPlaneNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("AirPlaneNotFoundException thrown!");
            e.printStackTrace();
        }
    }

    @Test
    void addAirPlane() {
        AirPlane plane1 = new AirPlane("CCC00001", 5, 5, AirPlaneStatus.HANGAR);
        AirPlane plane2 = new AirPlane("CCC00002", 10, 5, AirPlaneStatus.HANGAR);
        AirPlane plane3 = new AirPlane("CCC00003", 6, 4, AirPlaneStatus.HANGAR);
        AirPlane plane4 = new AirPlane("CCC00004", 1, 9, AirPlaneStatus.HANGAR);
        AirPlane plane5 = new AirPlane("CCC00005", 20, 10, AirPlaneStatus.HANGAR);

        AirPlaneListHandler airPlaneList = new AirPlaneListHandler();

        //Lägg till nya fygplan i listan
        assertTrue(airPlaneList.addAirPlane(plane1));
        assertTrue(airPlaneList.addAirPlane(plane2));
        assertTrue(airPlaneList.addAirPlane(plane3));
        assertTrue(airPlaneList.addAirPlane(plane4));
        assertTrue(airPlaneList.addAirPlane(plane5));

        //Testa att lägga till ett redan existerande flygplan i listan.
        assertFalse(airPlaneList.addAirPlane(plane5));


        System.out.println(airPlaneList);
    }

    @Test
    void removeAirPlaneFromList() {
    }

    @Test
    void addAirPlaneToDB() {
    }

    @Test
    void removeAirPlaneFromDB() {
    }

    @Test
    void retrieveAirPlaneListFromDB() {
    }
}