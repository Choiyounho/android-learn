package com.soten.androidstudio.learn.exam

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephone_directory)

        createPhoneBookList(createFakePhoneBook(30))
    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(Person(name = "$i 번째 사람", number = "$i 번째 번호"))
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook) {
        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.telephone_container)
        for (i in 0 until phoneBook.personList.size) {
            val view = layoutInflater.inflate(R.layout.item_phonenumber, null)
            val userNameView: TextView = view.findViewById(R.id.user_name)
            val userPhoneNumber: TextView = view.findViewById(R.id.user_number)

            userNameView.text = phoneBook.personList[i].name
            userPhoneNumber.text = phoneBook.personList[i].number
            addSetOnClickListener(phoneBook.personList[i], view)
            container.addView(view)
        }
    }

    fun addSetOnClickListener(person: Person, view: View) {
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class PhoneBook() {

    val personList = ArrayList<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }
}

class Person(val name: String, val number: String) {

}
