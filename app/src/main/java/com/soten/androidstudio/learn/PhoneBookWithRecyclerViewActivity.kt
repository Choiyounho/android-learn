package com.soten.androidstudio.learn

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soten.androidstudio.learn.exam.Person
import com.soten.androidstudio.learn.exam.PhoneBook
import com.soten.androidstudio.learn.exam.PhoneBookDetailActivity

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.phonebook_recyclerview)

        with(recyclerView) {
            this.adapter = PhoneBookRecyclerAdapter(
                phonebookList = createFakePhoneBook(30),
                LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                activity = this@PhoneBookWithRecyclerViewActivity)
            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }
    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(Person(name = "$i 번째 사람", number = "$i 번째 번호"))
        }
        return phoneBook
    }

}

class PhoneBookRecyclerAdapter(
    val phonebookList: PhoneBook, val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView = itemView.findViewById(R.id.person_name)

        init {
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)

                intent.putExtra("name", phonebookList.personList[adapterPosition].name)
                intent.putExtra("number", phonebookList.personList[adapterPosition].number)

                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = phonebookList.personList[position].name
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }

}