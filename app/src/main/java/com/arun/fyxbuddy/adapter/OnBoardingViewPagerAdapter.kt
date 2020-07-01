package com.arun.fyxbuddy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.arun.fyxbuddy.R
import com.arun.fyxbuddy.model.OnBoardingData
import kotlinx.android.synthetic.main.onboarding_screen_layout.view.*

class OnBoardingViewPagerAdapter(private var context: Context,private var onBoardingDataList:List<OnBoardingData>):PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view ==`object`
    }

    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout,null)

        /*var imageView:ImageView
        imageView = view.findViewById(R.id.imageView)
        imageView.setImageResource(onBoardingDataList[position].imageUrl)*/

        view.imageView.setImageResource(onBoardingDataList[position].imageUrl)
        view.title.text = onBoardingDataList[position].title
        view.desc.text = onBoardingDataList[position].desc

        container.addView(view)
        return view
    }
}