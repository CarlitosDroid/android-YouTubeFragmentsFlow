package com.carlitosdroid.android_youtubefragmentsflow.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlitosdroid.android_youtubefragmentsflow.R
import com.carlitosdroid.android_youtubefragmentsflow.ui.detail.DetailActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment
@Inject constructor() : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<String>()
        for (i in 1..20) {
            list.add("HOME $i")
        }
        val homeAdapter = HomeAdapter(list) {
            startActivity(Intent(context, DetailActivity::class.java))
        }
        rvHome.adapter = homeAdapter
        homeAdapter.notifyDataSetChanged()
    }
}