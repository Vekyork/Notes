package com.android.lesson8.notes.ui.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lesson8.notes.R;
import com.android.lesson8.notes.domain.Note;
import com.android.lesson8.notes.domain.NotesRepository;
import com.android.lesson8.notes.domain.NotesRepositoryImpl;
import com.android.lesson8.notes.ui.MainActivity;

import java.util.List;

public class NotesFragment extends Fragment {

    public static final String TAG = "NotesFragment";
    private final NotesRepository repository = NotesRepositoryImpl.INSTANCE;
    private final NotesAdapter notesAdapter = new NotesAdapter();

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView notesList = view.findViewById(R.id.notes_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());

        notesList.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_separator));

        notesList.addItemDecoration(dividerItemDecoration);

        // notesList.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<Note> notes = repository.getNotes();

        notesAdapter.setData(notes);
        notesAdapter.setListener(new NotesAdapter.OnNoteClickedListener() {
            @Override
            public void onNoteClickedListener(@NonNull Note note) {

                if (requireActivity() instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) requireActivity();

                    mainActivity.getRouter().showNoteDetail(note);
                }
//                Snackbar.make(view, note.getTitle(), Snackbar.LENGTH_SHORT).show();
            }
        });

        notesList.setAdapter(notesAdapter);

//        for (Note note : notes) {
//
//            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, containerView, false);
//
//            TextView title = itemView.findViewById(R.id.title);
//            ImageView image = itemView.findViewById(R.id.image);
//
//            title.setText(note.getTitle());
//
//            Glide.with(this)
//                    .load(note.getUrl())
//                    .centerCrop()
//                    .into(image);
//
//            containerView.addView(itemView);
//        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                notesAdapter.setData(new ArrayList<>());
//                notesAdapter.notifyDataSetChanged();
//
//            }
//        }, 2000L);
//
//    }
}
