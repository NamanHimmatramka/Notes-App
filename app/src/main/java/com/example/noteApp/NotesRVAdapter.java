package com.example.noteApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesRVAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    Context context;
    List<Note> allNotes = new ArrayList<>();
    INotesRVAdapter listener;

    NotesRVAdapter(Context context, INotesRVAdapter listener){
    this.context = context;
    this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NoteViewHolder viewHolder = new NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent, false));
        View.OnClickListener onClickListener = v -> listener.onItemClicked(allNotes.get(viewHolder.getAdapterPosition()));
        viewHolder.deleteButton.setOnClickListener(onClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = allNotes.get(position);
        holder.textView.setText(currentNote.getNote());
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public void updateList(List<Note> updatedList){
        allNotes.clear();
        allNotes.addAll(updatedList);

        notifyDataSetChanged();
    }
}

class NoteViewHolder extends RecyclerView.ViewHolder{

    NoteViewHolder(View itemView){
        super(itemView);
    }

    TextView textView = itemView.findViewById(R.id.text);
    ImageView deleteButton = itemView.findViewById(R.id.deleteButton);
}
interface INotesRVAdapter{
    void onItemClicked(Note note);
}