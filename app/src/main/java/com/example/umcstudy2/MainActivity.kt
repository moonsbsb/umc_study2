package com.example.umcstudy2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.umcstudy2.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContentView(mainBinding.root)

        replaceFragmentMain(MainFragment())

        mainBinding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item2 -> replaceFragmentHome(MainFragment())
                R.id.item3 -> replaceFragmentCalendar(MainFragment())
                R.id.item4 -> replaceFragmentPencil(MainFragment())
            }
            true
        }

    }

    private fun replaceFragmentMain(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
    private fun replaceFragmentHome(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
    private fun replaceFragmentCalendar(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.rotate, R.anim.none)
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
    private fun replaceFragmentPencil(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.scale, R.anim.none)
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}