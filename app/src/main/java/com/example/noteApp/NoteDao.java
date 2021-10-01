package com.example.noteApp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Query("Select * FROM notes_table ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes();
}
