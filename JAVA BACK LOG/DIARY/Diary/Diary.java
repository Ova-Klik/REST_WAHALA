package Diary;

import CustomException.EntryNotFoundException;
import CustomException.InvalidStateException;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final String username;
    private final String PASSWORD;
    private boolean locked;
    private int entryCounter = 0;
    List<Entry> entries = new ArrayList<>();


    public Diary(String username, String password) {
        this.username = username;
        this.PASSWORD = password;
    }

    public String getUsername() {
        return username;
    }

    public int getSize() {
        return entries.size();
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlockDiary(String password) {
        if (!password.equals(this.PASSWORD)) return;
        setIsLocked(false);
    }

    private void setIsLocked(boolean locked) {
        this.locked = locked;
    }

    public void lockDiary() {
        setIsLocked(true);
    }

    public void createEntry(String title, String body) {
        invalidStateException();
        int id = ++entryCounter;
        Entry myEntry = new Entry(id, title, body);
        entries.add(myEntry);
    }

    public void deleteEntry(int id) {
        if(isLocked())return;
        entries.removeIf(entry -> entry.getId() == id);
    }

    public Entry findEntryById(int id) {
        invalidStateException();
    for (Entry entry : entries) {
            if(entry.getId() == id) return entry;
        }
        throw new EntryNotFoundException("Entry does not exist");
    }

    public void updateEntry(int id, String title, String body) {
        Entry toUpdate=findEntryById(id);
        toUpdate.setTitle(title);
        toUpdate.setBody(body);
    }

    public void invalidStateException(){
        if (isLocked()) throw new InvalidStateException("Your Diary is Locked, Kindly Open");
    }


    public String getPassword() {
        return PASSWORD;
    }
}

