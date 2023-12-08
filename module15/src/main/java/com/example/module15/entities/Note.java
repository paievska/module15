package com.example.module15.entities;

import java.util.UUID;

public class Note {
    private UUID id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(UUID randomUUID) {
        this.id = id;
    }
}
