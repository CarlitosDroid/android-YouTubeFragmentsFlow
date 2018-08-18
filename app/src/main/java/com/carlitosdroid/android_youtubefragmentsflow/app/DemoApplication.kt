package com.carlitosdroid.android_youtubefragmentsflow.app

import com.carlitosdroid.android_youtubefragmentsflow.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @author carlosleonardocamilovargashuaman on 8/17/18.
 */
class DemoApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().application(this).build()
}