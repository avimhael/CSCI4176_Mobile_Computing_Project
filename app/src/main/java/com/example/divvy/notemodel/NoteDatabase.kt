package com.example.divvy.notemodel

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities=arrayOf(Notes::class), version=1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getInstance(context: Context):NoteDatabase{
            synchronized(this) {
                var instance = INSTANCE
                    if (instance==null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            NoteDatabase::class.java,
                            "notedatabase"
                        ).build()
                }
                return instance
            }
        }
    }
}