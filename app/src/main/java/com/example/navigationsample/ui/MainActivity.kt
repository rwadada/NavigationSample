package com.example.navigationsample.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.android.NavigationHandler
import com.example.navigationsample.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigation: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.first_page -> {
                        NavigationHandler.navigation.navigateFirst()
                        return true
                    }
                    R.id.second_page -> {
                        NavigationHandler.navigation.navigateSecond()
                        return true
                    }
                    R.id.third_page -> {
                        NavigationHandler.navigation.navigateThird()
                        return true
                    }
                }
                return false
            }
        })
    }

}