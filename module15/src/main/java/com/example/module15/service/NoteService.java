package com.example.module15.service;

import com.example.module15.entities.Note;
import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(Long id);
    void update(Note note);
    Note getById(Long id);
}
