package com.example.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateAdded")
    fun getNotesOrdedByDateAdded(): Flow<List<Note>>

    @Query("SELECT * FROM note ORDER by title ASC")
    fun getNotesOrderByTitle(): Flow<List<Note>>
}