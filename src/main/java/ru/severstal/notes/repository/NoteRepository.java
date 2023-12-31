package ru.severstal.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.severstal.notes.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
}