package Diary;

import CustomException.EntryNotFoundException;
import CustomException.InvalidStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DiaryTest {

    private Diary myDiary;
    private String username;
    private final String PASSWORD = "correctPassword";

    @BeforeEach
    void setUp() {
        myDiary = new Diary(username, PASSWORD);
    }

    @Test
    void testDiaryIsExisting() {
        assertNotNull(myDiary);

    }

    @Test
    void testDiaryIsCreated_diaryIsEmpty() {
        assertEquals(0, myDiary.getSize());

    }

    @Test
    void diaryIsCreated_diaryIsUnLockTest() {
        assertFalse(myDiary.isLocked());
    }

    @Test
    void diaryIsUnlocked_lockDiary_diaryShouldBeLockedTest() {
        assertFalse(myDiary.isLocked());
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }

    @Test
    void diaryIsLocked_unlockDiaryWithIncorrectPassword_diaryShouldRemainLockedTest() {
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary("password");
        assertTrue(myDiary.isLocked());
    }

    @Test
    void diaryIsLocked_unLockDiaryWithCorrectPassword_diaryShouldBeUnLockedTest() {
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary(PASSWORD);
        assertFalse(myDiary.isLocked());

    }

    @Test
    void diaryIsUnlock_createOneEntry_diaryShouldContainOneTest() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Love", "I love Omosola");
        assertEquals(1, myDiary.getSize());

    }

    @Test
    void diaryIsLock_createOneEntry_diaryThrowsException() {
        assertFalse(myDiary.isLocked());
        myDiary.lockDiary();
        assertThrows(InvalidStateException.class, () -> myDiary.createEntry("Love", "I love Omosola"));
        assertEquals(0, myDiary.getSize());

    }

    @Test
    void diaryIsUnlock_createOneEntryDeleteOneEntry_diaryIsEmptyTest() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food","There are different types of taste profile");
        myDiary.deleteEntry(1);
        assertEquals(0, myDiary.getSize());
    }

    @Test
    void diaryIsUnlock_createTwoEntryDeleteOneEntry_diaryIsUnlocked() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Jokes","Mosola is Olodo");

        myDiary.deleteEntry(2);
        assertEquals(1,myDiary.getSize());
    }

    @Test
    void createOneEntry_lockeDiary_DeleteOneEntry_diaryShouldNotDeleteEntry() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.lockDiary();
        myDiary.deleteEntry(1);
        assertEquals(1,myDiary.getSize());
    }

    @Test
    void createTwoEntry_findEntryByID_diaryReturnsEntryWithIDTest() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Love", "There are different types of taste profile");
        assertEquals("Food",myDiary.findEntryById(1).getTitle());

    }

    @Test
    void createTwoEntry_findEntryByID_diaryThrowsException() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Love", "There are different types of taste profile");
        assertThrows(EntryNotFoundException.class,()->myDiary.findEntryById(3));
    }

    @Test
    void createTwoEntry_lockDiary_findEntryByID_diaryThrowsException() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Love", "There are different types of taste profile");
        myDiary.lockDiary();
        assertThrows(InvalidStateException.class,()->myDiary.findEntryById(2));
    }

    @Test
    void createTwoEntry_updateEntryWithID_diaryUpdateEntryID1() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Job", "I was a banker");
        myDiary.updateEntry(1,"Food","i am hungry");
        assertEquals("i am hungry", myDiary.findEntryById(1).getBody());
    }

    @Test
    void createTwoEntry_lockDiary_updateFirstEntry_diaryThrowsException() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Job", "I was a banker");
        myDiary.lockDiary();
        assertThrows(InvalidStateException.class,()->myDiary.updateEntry(1,"Food","i am hungry"));

    }

    @Test
    void createTwoEntry_updateEntryNonExistingID_diaryThrowsException() {
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("Food", "There are different types of taste profile");
        myDiary.createEntry("Job", "I was a banker");
        assertThrows(EntryNotFoundException.class,()->myDiary.updateEntry(3,"Food","i am hungry"));

    }


}

