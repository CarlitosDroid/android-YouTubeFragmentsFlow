package com.carlitosdroid.android_youtubefragmentsflow.ui.subscriptions

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlitosdroid.android_youtubefragmentsflow.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_subscriptions.*
import javax.inject.Inject

class SubscriptionsFragment
@Inject constructor() : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_subscriptions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = mutableListOf<String>()
        for (i in 1..20){
            list.add("CARLITOSDROID $i")
        }
        val subscriptionsAdapter = SubscriptionsAdapter(list) {

        }
        rvSubscriptions.adapter = subscriptionsAdapter
        subscriptionsAdapter.notifyDataSetChanged()
    }


}