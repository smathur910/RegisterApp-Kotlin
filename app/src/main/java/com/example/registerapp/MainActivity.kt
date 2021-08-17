package com.example.registerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = NavFragment();
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.mainLayout, firstFragment).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.topbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val actionLogout = AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you want to logout?")
            .setPositiveButton("Ok"){dialogInterface, which ->
                finish()
        }
            .setNegativeButton("Cancel", null)



        when(item.itemId){
            R.id.iLogout -> actionLogout.show()
        }
        return true
    }
}