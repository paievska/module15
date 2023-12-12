package com.example.module15.controllers;

import com.example.module15.entities.Note;
import com.example.module15.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Note>> getAll(){
        return noteService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> add(@RequestBody Note note) {
        return noteService.add(note);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> editNote(@RequestBody Note note) {
        return noteService.update(note);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note> deleteById(@PathVariable long id) {
        return noteService.deleteById(id);
    }
    @GetMapping
    public ResponseEntity<String> defaultEndpoint() {
        return new ResponseEntity<>("Hello:) Welcome to the Note API!", HttpStatus.OK);
    }
}
