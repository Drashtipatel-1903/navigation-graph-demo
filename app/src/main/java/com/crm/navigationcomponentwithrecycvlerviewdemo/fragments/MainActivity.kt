package com.crm.navigationcomponentwithrecycvlerviewdemo.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.crm.navigationcomponentwithrecycvlerviewdemo.R
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding : ActivityMainBinding
    lateinit var btmBar : AnimatedBottomBar
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        var toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var navigationView: NavigationView = binding.navId
        btmBar = binding.bottomBar
        var drawerLayout: DrawerLayout = binding.drawerLayout
        navController = findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.dashboardFragment,
            R.id.chatFragment,
            R.id.movieFragment,
            R.id.videoFragment
        ) , drawerLayout)
        setupActionBarWithNavController(navController , appBarConfiguration)
        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        var nav_conroller = findNavController(R.id.fragmentContainerView)
        return nav_conroller.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottomnav_menu, menu)
        btmBar.setupWithNavController(menu!! , navController)
        return super.onCreateOptionsMenu(menu)
    }
}