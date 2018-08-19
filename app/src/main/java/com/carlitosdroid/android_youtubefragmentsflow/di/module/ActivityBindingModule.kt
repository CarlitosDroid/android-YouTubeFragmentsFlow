package com.carlitosdroid.android_youtubefragmentsflow.di.module

import com.carlitosdroid.android_youtubefragmentsflow.ui.main.MainActivity
import com.carlitosdroid.android_youtubefragmentsflow.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

}