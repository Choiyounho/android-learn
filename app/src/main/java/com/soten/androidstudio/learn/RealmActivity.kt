package com.soten.androidstudio.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded() // 데이터베이스 동기화
            .build()

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        findViewById<Button>(R.id.button_realm_save).setOnClickListener {
            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "서울대학교"
                    this.location = "서울"
                }
            }
        }

        findViewById<Button>(R.id.button_realm_load).setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("Realmdata", "data : $data")
            }
        }

        findViewById<Button>(R.id.button_realm_delete).setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }

        }

    }
}