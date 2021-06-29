package com.neocaptainnemo.notesappjava.domain;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotesRepositoryImpl implements NotesRepository {

    public static final NotesRepository INSTANCE = new NotesRepositoryImpl();

    private final ArrayList<Note> notes = new ArrayList<>();

    private ExecutorService executor = Executors.newCachedThreadPool();

    private Handler handler = new Handler(Looper.getMainLooper());

    public NotesRepositoryImpl() {

        notes.add(new Note("id1", "Заметка № 1", "https://get.wallhere.com/photo/2560x1600-px-lake-mountain-nature-1092998.jpg", new Date()));
        notes.add(new Note("id2", "Заметка № 2", "https://www.free-wallpapers.su/data/media/21/big/pri5208.jpg", new Date()));
        notes.add(new Note("id3", "Заметка № 3", "https://i.pinimg.com/originals/d1/d5/37/d1d537dc25d42b824598a30f2aa0427c.jpg", new Date()));
        notes.add(new Note("id4", "Заметка № 4", "https://fs.tonkosti.ru/9a/qn/9aqn00ukupkwkg8c0ssw0wc4s.jpg", new Date()));
        notes.add(new Note("id5", "Заметка № 5", "https://get.wallhere.com/photo/2560x1600-px-landscape-trees-water-1110226.jpg", new Date()));
    }

    @Override
    public void getNotes(Callback<List<Note>> callback) {
        executor.execute(() -> {

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(() -> callback.onSuccess(notes));
        });
    }

    @Override
    public void clear() {
        notes.clear();
    }

    @Override
    public void add(String title, String imageUrl, Callback<Note> callback) {
        Note note = new Note(UUID.randomUUID().toString(), title, imageUrl, new Date());
        notes.add(note);
        callback.onSuccess(note);
    }

    @Override
    public void remove(Note note, Callback<Object> callback) {
        notes.remove(note);
        callback.onSuccess(note);
    }

    @Override
    public Note update(@NonNull Note note, @Nullable String title, @Nullable Date date) {

        for (int i = 0; i < notes.size(); i++) {

            Note item = notes.get(i);

            if (item.getId().equals(note.getId())) {

                String titleToSet = item.getTitle();
                Date dateToSet = item.getDate();


                if (title != null) {
                    titleToSet = title;
                }

                if (date != null) {
                    dateToSet = date;
                }

                Note newNote = new Note(note.getId(), titleToSet, note.getUrl(), dateToSet);

                notes.remove(i);
                notes.add(i, newNote);

                return newNote;
            }
        }

        return note;
    }

}