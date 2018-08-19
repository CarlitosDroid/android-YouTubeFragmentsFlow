package com.carlitosdroid.android_youtubefragmentsflow.ui.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlitosdroid.android_youtubefragmentsflow.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class LibraryFragment
@Inject constructor() : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}