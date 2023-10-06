package ru.severstal.notes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDTO {
    private int id;

    private String title;

    private String description;
}