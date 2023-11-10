package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gdsc_assign.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main, HomeFragment())
                .commit()
        }
        click()
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fcv_main,fragment)
        fragmentTransaction.commit()
    }
    private fun click() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            item -> when (item.itemId) {
                R.id.it_home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, HomeFragment()).commit()

                R.id.it_my_page -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, MyPageFragment()).commit()

            }
            true
        }
        binding.mainFab.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main, CreateFragment())
        }


    }
}

