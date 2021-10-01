package com.example.noteApp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao mNoteDao;
    LiveData<List<Note>> mAllNotes;

    NoteRepository(Application application){
        NoteRoomDatabase db  = NoteRoomDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotes = mNoteDao.getAllNotes();
    }

    void insert(Note note){
        NoteRoomDatabase.databaseWriteExecutor.execute(()->{mNoteDao.insert(note);});
    }

    void delete(Note note){
        NoteRoomDatabase.databaseWriteExecutor.execute(()->{mNoteDao.delete(note);});
    }
}
