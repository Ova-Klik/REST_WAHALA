package Diaries;

import CustomException.DiaryNotFoundException;
import CustomException.InvalidPasswordException;
import CustomException.InvalidUsernameException;
import Diary.Diary;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();


    public int getSize() {
        return diaries.size();
    }

    public void add(String username, String password) {
        Diary diary = new Diary(username,password);
        diaries.add(diary);

    }

    public Diary findDiaryByUsername(String username) {
        for (Diary diary : diaries) {
            if(diary.getUsername().equals(username)) return diary;

        }
        throw new DiaryNotFoundException("Diary not found!!");

    }

    public void deleteDiary(String username, String password) {
        Diary diaryToDelete= findDiaryByUsername(username);
        if(!diaryToDelete.getPassword().equals(password)) invalidPassword();
        diaries.remove(diaryToDelete);

    }

    public void invalidPassword() {
        throw new InvalidPasswordException("Invalid password!!");
    }

}

