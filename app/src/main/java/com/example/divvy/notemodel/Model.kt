package com.example.divvy.notemodel

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Notes(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    @SerializedName("ID")
    val noteID: Int?,

    @ColumnInfo(name = "noteAuthor")
    @SerializedName("author")
    val author: String?,

    @ColumnInfo(name = "date_created")
    @SerializedName("noteCreatedOn")
    val dateCreated: String?,

    @ColumnInfo(name = "keep_until")
    @SerializedName("noteKeepUntil")
    val dateKeepUntil: String?,

    @ColumnInfo(name = "message_body")
    @SerializedName("noteBodyInput")
    val messageBody: String?,
)
