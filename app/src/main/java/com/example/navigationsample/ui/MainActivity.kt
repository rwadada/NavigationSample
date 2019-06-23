package com.example.navigationsample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.NavigationHandler
import com.example.navigationsample.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val bottomNavigation: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationHandler.currentPosition.observe(this, Observer {
            val currentPosition: Int? = NavigationHandler.currentPosition.value
            if (currentPosition is Int) {
                val menu: Menu = bottomNavigation.menu
                val menuItem: MenuItem = menu.getItem(currentPosition)
                menuItem.isChecked = true
            }
        })

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.first_page -> {
                        if(NavigationHandler.currentPosition.value != NavigationHandler.firstPageId) {
                            NavigationHandler.navigation.navigateFirst()
                            return true
                        }
                    }
                    R.id.second_page -> {
                        if(NavigationHandler.currentPosition.value != NavigationHandler.secondPageId) {
                            NavigationHandler.navigation.navigateSecond()
                            return true
                        }
                    }
                    R.id.third_page -> {
                        if(NavigationHandler.currentPosition.value != NavigationHandler.thirdPageId) {
                            NavigationHandler.navigation.navigateThird()
                            return true
                        }
                    }
                }
                return false
            }
        })
    }
}