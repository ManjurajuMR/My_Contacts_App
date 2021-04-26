package com.example.my_contacts.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact_entity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contact_Dao():Contact_Dao
}