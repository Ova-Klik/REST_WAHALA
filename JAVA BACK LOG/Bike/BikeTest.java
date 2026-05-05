package Bike;

import CustomException.PowerStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest{
    Bike bike;


    @BeforeEach
    void setUp() {
        bike = new Bike();
    }

    @Test
    void bikeExistTest(){
        assertNotNull(bike);
    }

    @Test
    void bikeIsOffTest(){
        assertNotNull(bike);
        assertTrue(bike.checkPowerOff());
    }

    @Test
    void bikeIsOff_bikeTurnedOn_BikeIsOnTest(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        assertFalse(bike.checkPowerOff());
    }

    @Test
    void testWhenBikeIsTurnedOn_gearIsOne(){
        bike.turnOn();
        assertEquals(1, bike.getGear());
    }

    @Test
    void bikeIsOff_accelerateBike_bikeSpeedRemainsZero(){
        assertTrue(bike.checkPowerOff());
        bike.accelerate();
        assertEquals(0,bike.getSpeed());
    }

    @Test
    void bikeIsOn_bikeTurnedOn_ThrowsException(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        assertThrows(PowerStateException.class,()->bike.turnOn());

    }

    @Test
    void bikeIsOn_bikeAcceleratesOnGearOne_speedIncreasesByOneTest(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        bike.accelerate();
        assertEquals(1,bike.getSpeed());
    }

    @Test
    void bikeIsOn_bikeSpeedIs20_bikeShiftsGearToTwo_speedIncreaseByTwoTest(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        for(int speed = 0; speed<21; speed+= bike.getGear())bike.accelerate();
        assertEquals(21,bike.getSpeed());
        bike.accelerate();
        assertEquals(2,bike.getGear());
        assertEquals(23,bike.getSpeed());

    }

    @Test
    void bikeIsOn_bikeSpeedGetsTo31_bikeShiftsGearTo3_speedIncreaseBy3Test(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        for(int speed = 0; speed<31; speed+= bike.getGear())bike.accelerate();
        assertEquals(31,bike.getSpeed());
        bike.accelerate();
        assertEquals(3,bike.getGear());
        assertEquals(34,bike.getSpeed());
    }

    @Test
    void bikeIsOn_bikeSpeedGetsTo40_bikeShiftsGearTo4_speedIncreaseBy4Test(){
        assertTrue(bike.checkPowerOff());
        bike.turnOn();
        for(int speed = 0; speed < 41; speed += bike.getGear()) bike.accelerate();
        assertEquals(43, bike.getSpeed());

        bike.accelerate();
        assertEquals(4, bike.getGear());
        assertEquals(47, bike.getSpeed());
    }


    @Test

    void bikeIsOff_bikeCannotDecelerate(){
        bike.checkPowerOff();
        assertEquals(1,bike.getGear());
        assertEquals(0, bike.getSpeed());

        bike.decelerate();
        assertEquals(0, bike.getSpeed());

    }

    @Test
    void bikeIsOnGearOne_decelerateDecreaseSpeedByOne() {
        bike.turnOn();
        assertEquals(0,bike.getSpeed());
        bike.accelerate();
        assertEquals(1,bike.getSpeed());
        bike.decelerate();
        assertEquals(0,bike.getSpeed());

    }

    @Test
    void bikeIsOnGearTwo_decelerateDecreaseSpeedByTwo() {
        bike.turnOn();
        assertEquals(1,bike.getGear());
        for(int speed = 0; speed<25; speed+= bike.getGear())bike.accelerate();
        bike.decelerate();
        assertEquals(2,bike.getGear());
        assertEquals(23,bike.getSpeed());
    }

    @Test
    void bikeIsOnGearThree_decelerateDecreaseSpeedByThree() {
        bike.turnOn();
        assertEquals(1,bike.getGear());
        for(int speed = 0; speed<37; speed+= bike.getGear()) bike.accelerate();
        assertEquals(3,bike.getGear());
        assertEquals(37,bike.getSpeed());
        bike.decelerate();
        assertEquals(34,bike.getSpeed());
    }

    @Test
    void bikeIsOnGearFour_decelerateDecreaseSpeedByFour(){
        bike.turnOn();
        assertEquals(1,bike.getGear());
        for(int speed = 0; speed<51; speed+= bike.getGear()) bike.accelerate();
        assertEquals(51,bike.getSpeed());
        bike.decelerate();
        assertEquals(47,bike.getSpeed());
    }

}