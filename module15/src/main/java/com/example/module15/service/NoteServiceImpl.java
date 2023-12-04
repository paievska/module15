package com.example.module15.service;

import com.example.module15.entities.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteServiceImpl implements NoteService {
    private final List<Note> notes = new ArrayList<>();
    private final Random random = new Random();

    private long generateUniqueId() {
        return random.nextLong();
    }

    @Override
    public List<Note> listAll() {
        return notes;
    }

    @Override
    public Note add(Note note) {
        note.setId(generateUniqueId());
        notes.add(note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    @Override
    public void update(Note note) {
        for (Note oldNote : notes) {
            if (oldNote.getId() == note.getId()) {
                oldNote.setTitle(note.getTitle());
                oldNote.setContent(note.getContent());
                return;
            }
        }
        throw new IllegalArgumentException("Error: Note not found with id: " + note.getId());
    }

    @Override
    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new IllegalArgumentException("Error: Note not found with id: " + id);
    }
}
