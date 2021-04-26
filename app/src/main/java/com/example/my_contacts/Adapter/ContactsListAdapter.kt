package com.example.my_contacts.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_contacts.R
import com.example.my_contacts.db.Contact_entity

class ContactsListAdapter(private val myContactslist: List<Contact_entity>,private val listener: OnItemClickListener):RecyclerView.Adapter<ContactsListAdapter.ContactviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactviewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return ContactviewHolder(inflater.inflate(R.layout.layout_contacts, parent, false))
    }

    override fun onBindViewHolder(holder: ContactviewHolder, position: Int) {
       // myContactslist.sortWith(compareBy { it.ContactName })
        var nContactlist=myContactslist[position]
        holder.name.text=nContactlist.ContactName
        holder.mob_no.text=nContactlist.ContactNumber.toString()
    }

    override fun getItemCount(): Int {
        return myContactslist.size
    }

    inner class ContactviewHolder(item:View):RecyclerView.ViewHolder(item),View.OnClickListener{
        var name=item.findViewById<TextView>(R.id.name)
        var mob_no=item.findViewById<TextView>(R.id.mob_no)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position=adapterPosition
            if (position!=RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}