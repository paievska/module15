package com.example.module15.service;

import com.example.module15.NoteRepository;
import com.example.module15.entities.Note;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;
    private final Random random = new Random();

    @PostConstruct
    public void init(){
        System.out.println("repository.getClass() = " + repository.getClass());
    }

    private long generateUniqueId() {
        return random.nextLong();
    }

    @Override
    public ResponseEntity<List<Note>> getAll() {
        List<Note> notes = repository.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Note> add(Note note) {
        note.setId(generateUniqueId());
        Note addedNode = repository.save(note);
        return new ResponseEntity<>(addedNode, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Note> deleteById(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Note> update(Note note) {
        if (repository.existsById(note.getId())) {
            repository.save(note);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Note> getById(Long id) {
        return repository.findById(id)
                .map(note -> new ResponseEntity<>(note, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
