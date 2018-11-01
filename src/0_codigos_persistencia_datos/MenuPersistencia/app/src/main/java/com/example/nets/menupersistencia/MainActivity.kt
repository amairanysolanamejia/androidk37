package com.example.nets.menupersistencia

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        lateinit var fragmentString : String //de que fragment estamos hablando?
        when (item.itemId) {
            R.id.navigation_home -> {
                fragmentString = "sp"

                createFragment(fragmentString)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
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

    private fun createFragment(fragmentName: String){

        val transaction = manager.beginTransaction()

        if (fragmentName == "sp"){
            var fragment = SPFragment()
            transaction.replace(R.id.fragment_holder, fragment)
        }

        transaction.addToBackStack(null)
        transaction.commit()

    }
}
