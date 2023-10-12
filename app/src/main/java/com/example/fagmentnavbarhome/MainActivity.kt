package com.example.fagmentnavbarhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import com.example.fagmentnavbarhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId){
                R.id.home ->replaceFragment(Home())
                R.id.search ->replaceFragment(search())
                R.id.profil ->replaceFragment(profil())

                else ->{

                }
            }
            true

        }
    }

    private  fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransction = fragmentManager.beginTransaction()
        fragmentTransction.replace(R.id.framelayout,fragment)
        fragmentTransction.commit()
    }
}