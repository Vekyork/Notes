package com.android.lesson8.notes.ui;

import androidx.fragment.app.FragmentManager;

import com.android.lesson8.notes.R;
import com.android.lesson8.notes.domain.Note;
import com.android.lesson8.notes.ui.info.InfoFragment;
import com.android.lesson8.notes.ui.notes.NotesFragment;

public class MainRouter {

    private final FragmentManager fragmentManager;

    public MainRouter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showNotes() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, NotesFragment.newInstance(), NotesFragment.TAG)
                .commit();
    }

    public void showInfo() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, InfoFragment.newInstance(), InfoFragment.TAG)
                .commit();
    }

    public void showNoteDetail(Note note) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, NoteDetailsFragment.newInstance(note), NoteDetailsFragment.TAG)
                .addToBackStack(NoteDetailsFragment.TAG)
                .commit();
    }

}
