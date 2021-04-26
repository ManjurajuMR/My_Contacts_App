package com.example.my_contacts.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contact_entity (
        @PrimaryKey
        var ContactName:String,
        @ColumnInfo(name = "ContactNumber")
        var ContactNumber:Long
        )