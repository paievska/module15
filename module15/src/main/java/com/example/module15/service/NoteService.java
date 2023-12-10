package com.example.module15.service;

import com.example.module15.entities.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoteService {
    ResponseEntity<List<Note>> getAll();
    ResponseEntity<Note> add(Note note);
    ResponseEntity<Note> deleteById(Long id);
    ResponseEntity<Note> update(Note note);
    ResponseEntity<Note> getById(Long id);
}
