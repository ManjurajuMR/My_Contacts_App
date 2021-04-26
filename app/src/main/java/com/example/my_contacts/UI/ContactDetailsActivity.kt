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

class ContactDetailsActivity : AppCompatActivity() {

    var  mycontactdatabase:AppDatabase?=null

    lateinit var name:TextView
    lateinit var mobile:TextView
    lateinit var delete:TextView
    lateinit var edit:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

         name=findViewById<TextView>(R.id.name)
         mobile=findViewById<TextView>(R.id.mobile_number)
         delete=findViewById<TextView>(R.id.delete)
         edit=findViewById<TextView>(R.id.edit)

        val bundle=intent.extras
        val position=bundle!!.getInt("position")
        //var mainActivity=MainActivity()
        var contacts=contacts()
        val contact=contacts[position]
        name.text=contact.ContactName
        mobile.text=contact.ContactNumber.toString()


        delete.setOnClickListener {
           // var mainActivity=MainActivity()
            val contact=contacts[position]
            mycontactdatabase!!.contact_Dao().delete(contact)
           // mainActivity.contactListAdapter?.notifyDataSetChanged()
            Toast.makeText(this, "your contact is deleted", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        edit.setOnClickListener {
            var data= MainActivity()
            val intent= Intent(this, EditContactActivity::class.java)
            intent.putExtra("position",position)
            startActivity(intent)
            finish()
        }

    }

    fun contacts(): List<Contact_entity> {
         mycontactdatabase=Room.databaseBuilder<AppDatabase>(applicationContext,AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
        //MainActivity.mycontactdatabase =Room.databaseBuilder<AppDatabase>(applicationContext,AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.contact_Dao().getUser()
        return contacts
    }

   override fun onBackPressed() {
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}