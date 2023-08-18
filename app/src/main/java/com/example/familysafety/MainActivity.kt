package com.example.familysafety


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.familysafety.Guard.Companion.newInstance
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottombar = findViewById<BottomNavigationView>(R.id.bottom_bar)
         bottombar.setOnItemSelectedListener { menuItem->

             when (menuItem.itemId) {
                 R.id.nav_home-> {
                     inflateFragment(Home.newInstance())
                 }
                 R.id.nav_dashboard-> {
                     inflateFragment(MapsFragment())
                 }
                 R.id.nav_guard-> {
                     inflateFragment(newInstance())
                 }
                 R.id.nav_profile-> {
                     inflateFragment(Profile.newInstance())
                 }
             }
             true
         }
        bottombar.selectedItemId=R.id.nav_home
    }




    private fun inflateFragment(newInstance:Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}