package com.example.my_contacts.db

import androidx.room.*

@Dao()
interface Contact_Dao {

    @Insert
    fun addUser(user:Contact_entity)

    @Query("Select * from Contacts order by Lower(ContactName)")
    fun getUser():List<Contact_entity>

    @Delete
    fun delete(user: Contact_entity)
    //@Query("delete from user where user_id =:id")
  //  fun delete(id:Int)

    //@Update
    @Query("update Contacts set ContactName=:NewContactName,ContactNumber=:NewContactNumber  where ContactName=:OldContactName")
    fun update(NewContactName:String,NewContactNumber:Long,OldContactName:String)
}