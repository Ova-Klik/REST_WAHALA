package Diaries;

import CustomException.DiaryNotFoundException;
import CustomException.InvalidPasswordException;
import CustomException.InvalidUsernameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

class DiariesTest {
   private Diaries diaries;

    @BeforeEach
    void setUp() {
        diaries = new Diaries();
    }

    @Test
    void diaryCollectionExist(){

        assertNotNull(diaries);
    }

    @Test
    void diaryCollectionIsEmpty(){
         assertEquals(0, diaries.getSize());
    }

    @Test
    void diaryCollectionIsEmpty_addOneDiary_diaryCollectionContainsOneDiary(){
        diaries = new Diaries();
        diaries.add("Mosola","correctPassword");
        assertEquals(1, diaries.getSize());
    }

    @Test
    void addTwoDiaries_findDiaryByUsername_diariesReturnDiary(){
        diaries = new Diaries();
        diaries.add("Mosola","2345");
        diaries.add("Victor","1234");

        assertEquals("Victor",diaries.findDiaryByUsername("Victor").getUsername());
    }

    @Test
    void addTwoDiaries_findDiaryByNonExistingUsername_diariesThrowsException(){
        diaries = new Diaries();
        diaries.add("Mosola","2345");
        diaries.add("Victor","1234");

        assertThrows(DiaryNotFoundException.class,()->diaries.findDiaryByUsername("Job"));
    }

    @Test
    void addTwoDiaries_deleteADiaryWithUsernameAndPassword_diariesContainOneDiary(){
        diaries = new Diaries();
        diaries.add("Mosola","2345");
        diaries.add("Victor","1234");

        diaries.deleteDiary("Victor","1234");
        assertEquals(1,diaries.getSize());
    }

    @Test
    void addTwoDiaries_deleteADiaryWIthWrongUsernameOrPassword_diariesContainOneDiary(){
        diaries = new Diaries();
        diaries.add("Mosola","2345");
        diaries.add("Victor","1234");

        assertThrows(InvalidPasswordException.class,()->diaries.deleteDiary("Victor","0000"));
        assertEquals(2,diaries.getSize());
    }

}