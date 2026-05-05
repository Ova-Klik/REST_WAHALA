import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ACTest {
    private final int INITIAL_ON_TEMPERATURE = 24;
    private final int OFF_TEMPERATURE = 0;

    AC airCondition;

    @BeforeEach
    void setUp() {
        airCondition = new AC();
    }

    @Test
    void testAirConditionerExist() {
        assertNotNull(airCondition);
    }

    @Test
    void testAirConditionIsOff() {
        assertTrue(airCondition.isOff());
    }

    @Test
    void testAirConditionerIsOff_whenTurnedOn_airConditionerIsOn() {
        assertTrue(airCondition.isOff());
        airCondition.turnOn();
        assertFalse(airCondition.isOff());
    }

    @Test
    void testAirConditionIsOff_whenTurnedOn_TemperatureIs24() {
        assertTrue(airCondition.isOff());
        airCondition.turnOn();
        assertEquals(INITIAL_ON_TEMPERATURE, airCondition.getTemperature());
    }

    @Test
    void testTemperatureIs24Deg_reduceTemperature_temperatureREduceBy2Deg() {
        airCondition.turnOn();
        airCondition.decreaseTemperature();
        assertEquals(22, airCondition.getTemperature());
    }

    @Test
    void testTemperatureIs16Deg_reduceTemperature_TemperatureRemain16Deg() {
        airCondition.turnOn();
        assertEquals(INITIAL_ON_TEMPERATURE, airCondition.getTemperature());
        for (int count = 5; count > 0; count--) {
            airCondition.decreaseTemperature();
        }

        assertEquals(16, airCondition.getTemperature());

    }

    @Test
    void testAirConditionIsOn_increaseTemperature_temperatureIncreaseBy2Deg() {
        airCondition.turnOn();
        assertEquals(INITIAL_ON_TEMPERATURE, airCondition.getTemperature());
        airCondition.increaseTemperature();
        assertEquals(26, airCondition.getTemperature());

    }

    @Test
    void testTemperatureIs30_increaseTemperature_temperatureRemains30() {
        airCondition.turnOn();
        for (int count = 4; count > 0; count--) {
            airCondition.increaseTemperature();
        }
        assertEquals(30, airCondition.getTemperature());

    }

    @Test
    void testBikeIsOff_increaseTemperature_temperatureRemainsZero(){
        airCondition.increaseTemperature();
        assertEquals(OFF_TEMPERATURE,airCondition.getTemperature());
}

    @Test
    void testBikeIsOff_decreaseTemperature_temperatureRemainsZero(){
        airCondition.decreaseTemperature();
        assertEquals(OFF_TEMPERATURE,airCondition.getTemperature());
    }

}