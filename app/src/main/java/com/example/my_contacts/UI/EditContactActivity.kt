package com.example.my_contacts.UI


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.my_contacts.R
import com.example.my_contacts.db.AppDatabase
import com.example.my_contacts.db.Contact_entity


class EditContactActivity : AppCompatActivity() {
    var  mycontactdatabase:AppDatabase?=null
    lateinit var name:TextView
    lateinit var mobile:TextView
    lateinit var save_changes:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        name = findViewById<TextView>(R.id.addname)
        mobile = findViewById<TextView>(R.id.addmobile_number)
        save_changes = findViewById<TextView>(R.id.add_btn)

        val bundle = intent.extras
        val position = bundle!!.getInt("position")
        var contacts = contacts()
        var contact=contacts[position]
        var oldcontactname=contact.ContactName
        name.text = contact.ContactName
        mobile.text = contact.ContactNumber.toString()

        save_changes.setOnClickListener {
            val updatedname = name.text.toString()
            val updatedmobile = mobile.text.toString()
            when {
                updatedname.isEmpty() -> {
                    name.error = "Name cannot be empty"
                    name.requestFocus()
                }
                updatedmobile.isEmpty() -> {
                    mobile.error = "Phone Number cannot be empty"
                    mobile.requestFocus()
                }
                else -> {
                   // val mainactivity = MainActivity()
                   // ContactsManager.Contactdatalist.set(position, ContactsdataModel(newname, newmobile.toLong()))
                   // mainactivity.contactListAdapter?.notifyDataSetChanged()
                   // var updatedcontact=Contact_entity(updatedname,updatedmobile.toLong())
                    mycontactdatabase!!.contact_Dao().update(updatedname,updatedmobile.toLong(),oldcontactname)
                    Toast.makeText(this, "your contact is updated", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
    fun contacts(): List<Contact_entity> {
        mycontactdatabase= Room.databaseBuilder<AppDatabase>(applicationContext, AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
        //MainActivity.mycontactdatabase =Room.databaseBuilder<AppDatabase>(applicationContext,AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.contact_Dao().getUser()
        return contacts
    }

    override fun onBackPressed() {
        val intent=Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}