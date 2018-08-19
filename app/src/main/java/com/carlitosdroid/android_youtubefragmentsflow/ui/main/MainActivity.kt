package com.carlitosdroid.android_youtubefragmentsflow.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import com.carlitosdroid.android_youtubefragmentsflow.R
import com.carlitosdroid.android_youtubefragmentsflow.utils.ActivityUtils
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var injectedFragment: HomeFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Log.e("injected ", "injected $injectedFragment")


                var homeFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)

                Log.e("inject","homefrg $homeFragment")
                if (homeFragment == null) {
                    homeFragment = injectedFragment
                    ActivityUtils.addFragmentToActivity(supportFragmentManager, homeFragment, R.id.contentFrame)
                }

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trending -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_subscriptions -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_inbox -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_library -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
