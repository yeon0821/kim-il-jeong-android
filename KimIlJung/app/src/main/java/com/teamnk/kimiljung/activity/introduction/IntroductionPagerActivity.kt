package com.teamnk.kimiljung.activity.introduction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnk.kimiljung.R
import com.teamnk.kimiljung.activity.StartActivity
import com.teamnk.kimiljung.adapter.introduction.IntroductionPagerAdapter
import com.teamnk.kimiljung.databinding.ActivityIntroductionPagerBinding
import com.teamnk.kimiljung.utils.IntentUtil

class IntroductionPagerActivity : AppCompatActivity() {

    private val binding: ActivityIntroductionPagerBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_introduction_pager)
    }

    private val sharedPreferences by lazy {
        getSharedPreferences("introductionPage", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewPager()
        initNextLinearLayout()
        initTabLayout()
    }

    private fun initViewPager() {
        binding.vpViewPagerViewPager.adapter = IntroductionPagerAdapter(this)
        binding.tabLayoutViewPager.setupWithViewPager(binding.vpViewPagerViewPager)
    }

    private fun initNextLinearLayout() {
        binding.linearLayoutViewPager.setOnClickListener {
            val current = binding.vpViewPagerViewPager.currentItem
            binding.vpViewPagerViewPager.setCurrentItem(current + 1, true)
            if (current == 3) {
                IntentUtil.startIntentClearTop(this, StartActivity::class.java)
            }
        }
    }

    private fun initTabLayout() {
        when (binding.tabLayoutViewPager.id) {
            0 -> binding.tabLayoutViewPager.getTabAt(0)?.select()
            1 -> binding.tabLayoutViewPager.getTabAt(1)?.select()
            2 -> binding.tabLayoutViewPager.getTabAt(2)?.select()
            3 -> binding.tabLayoutViewPager.getTabAt(3)?.select()
            4 -> binding.tabLayoutViewPager.getTabAt(4)?.select()
        }
    }
}