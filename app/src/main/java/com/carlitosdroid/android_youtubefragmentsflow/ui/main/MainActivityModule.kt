package com.carlitosdroid.android_youtubefragmentsflow.ui.main

import com.carlitosdroid.android_youtubefragmentsflow.ui.subscriptions.SubscriptionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun trendingFragment(): TrendingFragment

    @ContributesAndroidInjector
    abstract fun subscriptionsFragment(): SubscriptionsFragment

    @ContributesAndroidInjector
    abstract fun inboxFragment(): InboxFragment

    @ContributesAndroidInjector
    abstract fun libraryFragment(): LibraryFragment
}