package com.example.my_contacts.UI


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.my_contacts.R
import com.example.my_contacts.db.Contact_entity

class AddContactActivity :AppCompatActivity() {
    lateinit var name:TextView
    lateinit var mobile:TextView
    lateinit var add_contact:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

           name = findViewById<TextView>(R.id.addname)
           mobile = findViewById<TextView>(R.id.addmobile_number)
           add_contact = findViewById<TextView>(R.id.add_btn)

        add_contact.setOnClickListener {
            val names = name.text.toString()
            val mobiles = mobile.text.toString()
            when {
                names.isEmpty() -> {
                    name.error = "Name cannot be empty"
                    name.requestFocus()
                }
                mobiles.isEmpty() -> {
                    mobile.error = "Phone Number cannot be empty"
                    mobile.requestFocus()
                }
                else -> {
                   // val mainactivity = MainActivity()
                    //ContactsManager.Contactdatalist.add(ContactsdataModel(names, mobiles.toLong()))
                    //mainactivity.contactListAdapter?.notifyDataSetChanged()
                    val newcontact=Contact_entity(names,mobiles.toLong())
                    MainActivity.mycontactdatabase!!.contact_Dao().addUser(newcontact)
                    Toast.makeText(this, "your contact is added", Toast.LENGTH_SHORT).show()
                   val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}