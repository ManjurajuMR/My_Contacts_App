package com.example.my_contacts.UI


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.my_contacts.Adapter.ContactsListAdapter
import com.example.my_contacts.R
import com.example.my_contacts.db.AppDatabase
import com.example.my_contacts.db.Contact_entity

class MainActivity : AppCompatActivity(), ContactsListAdapter.OnItemClickListener {
    companion object{
    var  mycontactdatabase:AppDatabase?=null
    //new
        //c1 branch only
        }


    var contactListAdapter: ContactsListAdapter?=null

    lateinit var newcontact:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecyclerview()
         newcontact=findViewById<Button>(R.id.newcontact)

        newcontact.setOnClickListener {
            val intent=Intent(this, AddContactActivity::class.java)
            startActivity(intent)
            finish()
        }
        //mycontactdatabase= Room.databaseBuilder<AppDatabase>(applicationContext,AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()

    }

fun contacts(): List<Contact_entity> {
    mycontactdatabase =Room.databaseBuilder<AppDatabase>(applicationContext,AppDatabase::class.java,"AppDb").allowMainThreadQueries().build()
    var contacts= mycontactdatabase!!.contact_Dao().getUser()
    return contacts
}
    override fun onItemClick(position: Int) {
        val intent= Intent(this, ContactDetailsActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
        finish()
    }


    private fun initializeRecyclerview(){
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        contactListAdapter= ContactsListAdapter(contacts(),this)
        recyclerView.adapter=contactListAdapter
    }


}
