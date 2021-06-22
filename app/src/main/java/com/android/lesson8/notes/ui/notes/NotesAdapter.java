package com.android.lesson8.notes.ui.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lesson8.notes.R;
import com.android.lesson8.notes.domain.Note;

import java.util.ArrayList;
import java.util.List;

import holder.image;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private Object image;

    public interface OnNoteClickedListener {
        void onNoteClickedListener(@NonNull Note note);
    }

    private final ArrayList<Note> notes = new ArrayList<>();

    public void setData(List<Note> toSet) {
        notes.clear();
        notes.addAll(toSet);
    }

    private OnNoteClickedListener listener;

    public OnNoteClickedListener getListener() {
        return listener;
    }

    public void setListener(OnNoteClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NoteViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the  to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use  which will
     * have the updated adapter position.
     * <p>
     * Override  instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NoteViewHolder holder, int position) {

    }

//    @Override
//    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
//
//        Note note = notes.get(position);
//
//        holder.title.setText(note.getTitle());
//
//        Glide.with((ImageView) image)
//                .load(note.getUrl())
//                .centerCrop()
//                .into(image);
//    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                if (getListener() != null) {
                    getListener().onNoteClickedListener(notes.get(getAdapterPosition()));
                }
            });

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
        }
    }

    private static class Glide {
        public static void with(ImageView image) {
        }
    }
}
