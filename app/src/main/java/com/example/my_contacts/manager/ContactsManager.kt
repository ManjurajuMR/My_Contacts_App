package com.example.my_contacts.manager

import androidx.room.Room
import com.example.my_contacts.UI.MainActivity
import com.example.my_contacts.db.AppDatabase
import com.example.my_contacts.db.Contact_entity

class ContactsManager {
    companion object {
        /*var Contactdatalist :MutableList<ContactsdataModel> = mutableListOf(ContactsdataModel("Manjuraju",8050251198),
                ContactsdataModel("arun",9916716266), ContactsdataModel("vijay",6591559245),
                ContactsdataModel("yathish",6578943512), ContactsdataModel("lohith",8946735168),
                ContactsdataModel("harsha",9086438725), ContactsdataModel("dhanu",6843816752))*/

   var contactdatabase:AppDatabase?=null

    }
   /*fun contacts(): List<Contact_entity> {
        contactdatabase = Room.databaseBuilder<AppDatabase>(applicationContext, AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
        var contacts= MainActivity.mycontactdatabase!!.contact_Dao().getUser()
        return contacts
    }*/
}