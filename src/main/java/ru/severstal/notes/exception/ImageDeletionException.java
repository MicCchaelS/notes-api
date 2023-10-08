package ru.severstal.notes.exception;

import lombok.Getter;

import java.io.IOException;
import java.io.Serial;

@Getter
public class ImageDeletionException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final IOException ioException;

    public ImageDeletionException(String message, IOException ioException) {
        super(message);
        this.ioException = ioException;
    }
}