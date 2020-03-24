import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Vehicle myVehicle;
    private static int myVehicleNum = 0;

    @BeforeEach
    void setUp() {
        myVehicle = new Vehicle();
        myVehicleNum++;
    }

    @AfterEach
    void tearDown() {
        myVehicle.finalize();
        myVehicleNum--;
    }

    @Test
    void testFinalize() {
        myVehicle.finalize();
        myVehicleNum--;
        assertEquals(myVehicleNum, myVehicle.totalVehicle());
    }

    @DisplayName("Test to set Speed")
    @Test
    void setSpeed() {
        int testSpeed = 10;
        myVehicle.setSpeed(testSpeed);
        assertEquals(testSpeed, myVehicle.getSpeed());
    }

    @DisplayName("Test to set Direction")
    @Test
    void setDir() {
        String testDir = "south";
        myVehicle.setDir(testDir);
        assertEquals(testDir, myVehicle.getDir());
    }

    @DisplayName("Test to get Speed")
    @Test
    void getSpeed() {
        assertEquals(0, myVehicle.getSpeed());
    }

    @DisplayName("Test to get Direction")
    @Test
    void getDir() {
        assertEquals("north", myVehicle.getDir());
    }

    @DisplayName("Test to get totalVehicle")
    @Test
    void totalVehicle() {
        assertEquals(myVehicleNum, myVehicle.totalVehicle());
    }
}