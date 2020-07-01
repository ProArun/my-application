package com.arun.fyxbuddy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.arun.fyxbuddy.adapter.OnBoardingViewPagerAdapter
import com.arun.fyxbuddy.model.OnBoardingData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter?=null
    var tabLayout: TabLayout?=null
    var onBoardingViewPager: ViewPager?=null
    var next: TextView?=null
    var position = 0
    var sharedPreferences : SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(restorePrefData()){
            val i = Intent(applicationContext,VerifyPhoneActivity::class.java)
            startActivity(i)
            finish()
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar!!.hide()

        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next)

        //lets add some data to our model class
        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Fresh Food","you will get the fresh food",R.drawable.sports))
        onBoardingData.add(OnBoardingData("fast Delivery","Fast delivary with hot meals",R.drawable.sports))
        onBoardingData.add(OnBoardingData("Easy pament","you can pay online",R.drawable.sports))

        setOnBoardingViewPagerAdapter(onBoardingData)

        next?.setOnClickListener {
            if (position<onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingData.size){
                savePrefData()

                val i = Intent(applicationContext,VerifyPhoneActivity::class.java)
                startActivity(i)
                finish()
            }
        }
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1){
                    next!!.text = "Get Started"
                }else{
                    next!!.text = "Next"
                }
            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData:List<OnBoardingData>){
        onBoardingViewPager = findViewById(R.id.screenViewPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this,onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter

        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }
    private fun restorePrefData():Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun",false)
    }
}