package com.example.noteApp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Note{

    @ColumnInfo(name = "notes")
    String mNote;

    @PrimaryKey(autoGenerate = true)
    int id;
    public Note(@NonNull String note){
        this.mNote=note;
    }
    public String getNote(){
        return this.mNote;
    }
}
