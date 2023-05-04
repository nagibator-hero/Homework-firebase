package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.dz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_fragment_host)
        binding.navigationViewRight.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.all_home_work -> {

                }
                R.id.math -> {

                }
                R.id.russian_language -> {

                }
                R.id.english_language -> {

                }
                R.id.phizicks -> {

                }
                R.id.informatics -> {

                }
                R.id.literature -> {

                }
                R.id.physical_culture -> {

                }
                R.id.introduction_to_the_profession -> {

                }
                R.id.history -> {

                }
                R.id.admin_button_nav_menu -> {
                        this.navController.navigate(R.id.action_fragment_rasp2_to_fragmentAdminPassword)
                }
            }
            true
        }
    }
}