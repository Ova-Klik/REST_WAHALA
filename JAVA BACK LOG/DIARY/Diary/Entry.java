package Diary;

import java.time.LocalDateTime;


public class Entry {
    private final int ID;
    private  String title;
    private String body;
    private LocalDateTime dateCreated;

public Entry(int id, String title,String body) {
    this.ID = id;
    this.title = title;
    this.dateCreated = LocalDateTime.now();

}

    public int getId() {
        return ID;
    }

    public String getTitle() {
    return title;
    }

    public void setTitle(String title) {
    this.title=title;
    }

    public void setBody(String body){
    this.body=body;
    }

    public String getBody() {
    return body;
    }
}

