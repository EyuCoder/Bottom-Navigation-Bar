package com.codexo.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codexo.bottomnavigationbar.fragments.FavoriteFragment
import com.codexo.bottomnavigationbar.fragments.HomeFragment
import com.codexo.bottomnavigationbar.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = HomeFragment();
        val favorite = FavoriteFragment();
        val settings = SettingsFragment();
        val navBar = findViewById<BottomNavigationView>(R.id.bottom_navbar)

        switchFragments(home)

        navBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> switchFragments(home)
                R.id.menu_favorite -> switchFragments(favorite)
                R.id.menu_settings -> switchFragments(settings)
            }
            true
        }
    }

    private fun switchFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }


}