import CustomException.IllegalArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    MySet mySet;

    @BeforeEach
    void setUp(){
        mySet = new MySet();
    }

    @Test
    void mySetExist(){
        assertNotNull(mySet);
    }

    @Test
    void mySet_MySetIsEmpty(){
        assertTrue(mySet.isEmpty());
    }

    @Test
    void mySetIsEmpty_addOneElement_setHasOneElement(){
        assertTrue(mySet.isEmpty());
        assertTrue(mySet.add("victor"));
        assertEquals(1, mySet.getSize());
    }

    @Test
    void mySetHasOneElement_addSameElementAgain_setHasOneElement(){
        mySet.add("victor");
        assertFalse(mySet.add("victor"));
        assertEquals(1, mySet.getSize());
    }

    @Test
    void mySetIsEmpty_addThreeElements_setHasThreeElements(){
        assertTrue(mySet.isEmpty());
        mySet.add("Victor");
        mySet.add("John");
        mySet.add("Jane");
        assertEquals(3, mySet.getSize());
    }

    @Test
    void mySetHas2Elements_removeExistingElement_setDecreasesByOne(){
        mySet.add("victor");
        mySet.add("john");
        assertTrue(mySet.remove("victor"));
        assertEquals(1, mySet.getSize());
    }

    @Test
    void mySetHas2Elements_removeNull_setThrowsException(){
        mySet.add("victor");
        mySet.add("john");
        assertFalse(mySet.remove(null));
        assertEquals(2, mySet.getSize());
    }

    @Test
    void mySetHas1Element_removeNonExistingElement_returnsFalse(){
        mySet.add("victor");
        assertFalse(mySet.remove("john"));
        assertEquals(1, mySet.getSize());
    }

    @Test
    void mySet1HasElement_checkExistingElement_returnsTrue(){
        mySet.add("victor");
        assertTrue(mySet.contains("victor"));
    }

    @Test
    void mySet1HasElement_checkNonExistingElement_returnsFalse(){
        mySet.add("victor");
        assertFalse(mySet.contains("john"));
    }

    @Test
    void mySetIsEmpty_addNullElement_mySetThrowsException(){
        assertTrue(mySet.isEmpty());
        assertThrows(NullPointerException.class, () -> mySet.add(null));
    }

    @Test
    void mySetHasOneElement_addParsesTwoArguments_mySetThrowsException(){
        mySet.add("victor");

        assertThrows(IllegalArgumentException.class, () -> mySet.add(""));

    }

    @Test
    void mySetHasElements_clearSet_setIsEmpty(){
        mySet.add("victor");
        mySet.add("john");
        mySet.clear();
        assertEquals(0, mySet.getSize());

    }

    @Test
    void mySetIsEmpty_clearSet_mySetRemains(){
        assertTrue(mySet.isEmpty());
        mySet.clear();

    }

    @Test
    void mySetHas2Elements_compareWithDifferentSet_setIsEqual(){
        mySet.add("victor");
        mySet.add("john");

        ArrayList<String> secondSet = new ArrayList<>();
        secondSet.add("victor");
        secondSet.add("john");
        assertTrue(mySet.equals(secondSet));

    }

    @Test
    void mySetHas2Elements_compareWithDifferentSet_setIsNotEqual(){
        mySet.add("victor");
        mySet.add("john");

        ArrayList<String> secondSet = new ArrayList<>();
        secondSet.add("Paul");
        secondSet.add("john");
            assertFalse(mySet.equals(secondSet));

    }

    @Test
    void mySetHas2Elements_compareWithDifferentSet_mySetContainsAllElement(){
        mySet.add("victor");
        mySet.add("John");
        mySet.add("Paul");

        ArrayList<String> secondSet = new ArrayList<>();
        secondSet.add("Paul");
        secondSet.add("John");
        assertTrue(mySet.containsAll(secondSet));
    }

    @Test
    void mySetHas2Elements_compareWithDifferentSet_mySetDoesntContainAllElementTest(){
        mySet.add("victor");
        mySet.add("John");
        mySet.add("Paul");

        ArrayList<String> secondSet = new ArrayList<>(Arrays.asList("Paul", "Bola"));
        assertFalse(mySet.containsAll(secondSet));
    }

    @Test
    void mySetHas2Elements_removeAllElementsInCollection_setChanges(){
        mySet.add("John");
        mySet.add("Paul");
    }

    @Test
    void mySetHas2Elements_retainAllElementsInCollection_setOnlyHasCommonElements(){
        mySet.add("victor");
        mySet.add("john");
        ArrayList<String> secondSet = new ArrayList<>(List.of("victor", "Paul"));
        assertTrue(mySet.retainAll(secondSet));
        assertEquals(1, mySet.getSize());
        assertTrue(mySet.contains("victor"));
    }

    @Test
    void mySetHas2Elements_retainAllWithNoCommonElements_setIsEmpty(){
        mySet.add("victor");
        mySet.add("john");
        ArrayList<String> secondSet = new ArrayList<>(List.of("Paul", "Bola"));
        assertTrue(mySet.retainAll(secondSet));
        assertTrue(mySet.isEmpty());
    }

    @Test
    void mySetIsEmpty_addAllElements_setHasAllElements(){
        ArrayList<String> secondSet = new ArrayList<>(List.of("victor", "john"));
        assertTrue(mySet.addAll(secondSet));
        assertEquals(2, mySet.getSize());
    }

    @Test
    void mySetHas2Elements_addAllWithDuplicates_setIgnoresDuplicates(){
        mySet.add("victor");
        ArrayList<String> secondSet = new ArrayList<>(List.of("victor", "john"));
        mySet.addAll(secondSet);
        assertEquals(2, mySet.getSize());
    }

    @Test
    void mySetHas2Elements_toArray_returnsArrayWithSameElements(){
        mySet.add("victor");
        mySet.add("john");
        Object[] array = mySet.toArray();
        assertEquals(2, array.length);
        assertTrue(mySet.contains((String) array[0]));
        assertTrue(mySet.contains((String) array[1]));
    }

    @Test
    void mySetIsEmpty_toArray_returnsEmptyArray(){
        Object[] array = mySet.toArray();
        assertEquals(0, array.length);
    }

}