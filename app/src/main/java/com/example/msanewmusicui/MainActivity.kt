package com.example.msanewmusicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.navigation_activity.*


class MainActivity : AppCompatActivity() {
    private lateinit var navCtrl: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

        navCtrl = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCtrl, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navCtrl)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navCtrl, drawer_layout)
    }
}