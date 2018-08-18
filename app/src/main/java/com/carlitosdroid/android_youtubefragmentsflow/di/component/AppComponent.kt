package com.carlitosdroid.android_youtubefragmentsflow.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

/**
 * @author carlosleonardocamilovargashuaman on 8/16/18.
 */
@Component(modules = [
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}