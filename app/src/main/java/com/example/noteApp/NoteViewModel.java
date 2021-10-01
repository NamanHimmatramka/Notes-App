package com.example.noteApp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository mNoteRepository;
    final LiveData<List<Note>> mAllNotes;

    public NoteViewModel(Application application) {
        super(application);
        mNoteRepository = new NoteRepository(application);
        mAllNotes = mNoteRepository.mAllNotes;
    }
    
    public void insert(Note note){
        mNoteRepository.insert(note);
    }
    public void delete(Note note){
        mNoteRepository.delete(note);
    }
}
