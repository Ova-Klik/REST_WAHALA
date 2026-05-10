
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestMiniParkingLot{

    MiniParkingLot park;
    
    @BeforeEach
    void setUp(){
    
        park = new MiniParkingLot();
    }    
        
   
    @Test
    public void shouldReturnTotalNumberOfSlots() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };

        int expected = 20;
        int actual = park.countParkingLot(lot);

        assertEquals(expected, actual);
                                            }

    @Test
    public void shouldReturnZeroWhenLotIsEmptyArray() {

        int[][] lot = {};

        int expected = 0;
        int actual = park.countParkingLot(lot);

        assertEquals(expected, actual);
                                            }


    @Test
    public void shouldReturnFalseWhenAllSlotsAreEmpty() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                        };
        
        boolean actual = park.checkIfLotIsFull(lot);
        boolean expected = false;
        assertEquals(actual,expected);
    }

    @Test
    public void shouldReturnFalseWhenAtLeastOneSlotIsOccupied() {

        int[][] lot = {
            {1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        boolean actual = park.checkIfLotIsFull(lot);

        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueWhenLotIsFull() {

        int[][] lot = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
                                        };

        boolean actual = park.checkIfLotIsFull(lot);

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseWhenAtLeastOneSlotIsEmpty() {

        int[][] lot = {
            {1,1,1,1,1,1,1,1,1,0},
            {1,1,1,1,1,1,1,1,1,1}
                                    };

        boolean actual = park.checkIfLotIsFull(lot);

        assertFalse(actual);
    }


    @Test
    public void shouldParkCarInFirstAvailableSlot() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        String command = "assign";

        int[][] expected = {
            {1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        int[][] actual = park.parkACarBySequence(lot, command);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldParkInNextAvailable() {

        int[][] lot = {
            {1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        String command = "assign";

        int[][] expected = {
            {1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        int[][] actual = park.parkACarBySequence(lot, command);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeLotWhenParkingAndLotIsFull() {

        int[][] lot = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
                                    };

        String command = "assign";

        int[][] actual = park.parkACarBySequence(lot, command);

        assertArrayEquals(lot, actual);
    }

  
    @Test
    public void shouldParkCarAtSpecifiedSlot() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        int lotNumber = 10;
        String command = "assign";

        int[][] expected = {
            {0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        int[][] actual = park.parkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotOverwriteIfSlotIsAlreadyOccupied() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0}
                                     };

        int lotNumber = 10;
        String command = "assign";

        int[][] actual = park.parkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(lot, actual);
    }

    @Test
    public void shouldIgnoreInvalidLotNumber() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
                                    };

        int lotNumber = 25; 
        String command = "assign";

        int[][] actual = park.parkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(lot, actual);
    }


    @Test
    public void shouldUnparkCarFromSpecifiedSlot() {

        int[][] lot = {
            {1,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0}
        };

        int lotNumber = 10;
        String command = "unassign";

        int[][] expected = {
            {1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };

        int[][] actual = park.unparkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotChangeLotWhenUnparkingEmptySlot() {

        int[][] lot = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };

        int lotNumber = 5;
        String command = "unassign";

        int[][] actual = park.unparkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(lot, actual);
    }

    @Test
    public void shouldIgnoreInvalidLotNumberWhenUnparking() {

        int[][] lot = {
            {1,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0}
        };

        int lotNumber = 30; 
        String command = "unassign";

        int[][] actual = park.unparkCarByLotNumber(lot, lotNumber, command);

        assertArrayEquals(lot, actual);
    }
}
   
    
    



