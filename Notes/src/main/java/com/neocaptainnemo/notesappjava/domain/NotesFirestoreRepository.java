package com.neocaptainnemo.notesappjava.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;

public class NotesFirestoreRepository implements NotesRepository{
    @Override
    public void getNotes(Callback<List<Note>> callback) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Note add(String title, String imageUrl) {
        return null;
    }

    @Override
    public void remove(Note note) {

    }

    @Override
    public Note update(@NonNull Note note, @Nullable String title, @Nullable Date date) {
        return null;
    }
}
