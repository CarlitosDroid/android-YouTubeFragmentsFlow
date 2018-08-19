package com.carlitosdroid.android_youtubefragmentsflow.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment
}