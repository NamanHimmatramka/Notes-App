package com.example.noteApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements INotesRVAdapter {

    NoteViewModel mViewModel;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        NotesRVAdapter adapter = new NotesRVAdapter(this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        mViewModel.mAllNotes.observe(this, adapter::updateList);
    }

    @Override
    public void onItemClicked(Note note) {
        mViewModel.delete(note);
        Toast.makeText(this, note.mNote + "Deleted", Toast.LENGTH_LONG).show();
    }

    public void submit(View view) {
        String noteText = input.getText().toString();
        if(!(noteText.isEmpty())){
            Note note = new Note(noteText);
            mViewModel.insert(note);
            Toast.makeText(this, note.mNote + "Inserted", Toast.LENGTH_LONG).show();
        }
    }
}