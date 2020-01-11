package com.peker.roomdatabase

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.peker.roomdatabase.database.AppDatabase
import com.peker.roomdatabase.database.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "RoomDatabase"
    private lateinit var database:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        database = AppDatabase.getDatabase(this)
        val list = database.userDao().getAllData()
        if(list.isNotEmpty())
        {
            list.forEach {
                Log.d(TAG,it.name + it.userInfo + " ${it.userId}")
            }
        }

        fab.setOnClickListener { view ->
            var user = User()
            user.name = "Mehmet Peker"
            user.userInfo = "Software Developer"
            database.userDao().addUser(user)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
