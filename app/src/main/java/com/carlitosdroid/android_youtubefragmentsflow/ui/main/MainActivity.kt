package com.carlitosdroid.android_youtubefragmentsflow.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import com.carlitosdroid.android_youtubefragmentsflow.R
import com.carlitosdroid.android_youtubefragmentsflow.ui.home.HomeFragment
import com.carlitosdroid.android_youtubefragmentsflow.ui.subscriptions.SubscriptionsFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var injectedHomeFragment: HomeFragment

    @Inject
    lateinit var injectedTrendingFragment: TrendingFragment

    @Inject
    lateinit var injectedSubscriptionsFragment: SubscriptionsFragment

    @Inject
    lateinit var injectedInboxFragment: InboxFragment

    @Inject
    lateinit var injectedLibraryFragment: LibraryFragment

    private val backStackList = mutableListOf<BackStack>()

    private val backStackHome = BackStack(TAG_BSS_HOME, R.id.navigation_home)
    private val backStackTrending = BackStack(TAG_BSS_TRENDING, R.id.navigation_trending)
    private val backStackSubscriptions = BackStack(TAG_BSS_SUBSCRIPTIONS, R.id.navigation_subscriptions)
    private val backStackInbox = BackStack(TAG_BSS_INBOX, R.id.navigation_inbox)
    private val backStackLibrary = BackStack(TAG_BSS_LIBRARY, R.id.navigation_library)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragmentToActivity(TAG_FRAGMENT_HOME, backStackHome, injectedHomeFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_trending -> {
                replaceFragmentToActivity(TAG_FRAGMENT_TRENDING, backStackTrending, injectedTrendingFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_subscriptions -> {
                replaceFragmentToActivity(TAG_FRAGMENT_SUBSCRIPTIONS, backStackSubscriptions, injectedSubscriptionsFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_inbox -> {
                replaceFragmentToActivity(TAG_FRAGMENT_INBOX, backStackInbox, injectedInboxFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_library -> {
                replaceFragmentToActivity(TAG_FRAGMENT_LIBRARY, backStackLibrary, injectedLibraryFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var homeFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)

        if (homeFragment == null) {
            homeFragment = injectedHomeFragment
        }

        if (!homeFragment.isAdded) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.contentFrame, homeFragment, TAG_FRAGMENT_HOME)
                addToBackStack(TAG_BSS_MAIN)
                commit()
            }
        }

        bnvMain.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragmentToActivity(fragmentTag: String, backStack: BackStack, injectedFragment: Fragment) {
        val oldFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
        var currentFragment = supportFragmentManager.findFragmentByTag(fragmentTag)

        Log.e("OLD FRAGMENT", "$oldFragment")
        Log.e("CURRENT FRAGMENT", "$currentFragment")

        if (currentFragment == null) {
            currentFragment = injectedFragment
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.contentFrame, currentFragment, fragmentTag)
            addToBackStack(backStack.stateTag)
            commit()
        }

        backStackList.remove(backStack)
        backStackList.add(backStack)
    }

    /**
     * We handle three scenarios:
     * If the size of list is greater than 2, return the penultimate transaction or back stack
     * If size of list is 1, return to the first and unique back stack state that was added in onCreate
     * If size of list is 0, there's no more states and just finish
     */
    override fun onBackPressed() {

        val backStackSize = backStackList.size
        when {
            backStackSize >= 2 -> {
                supportFragmentManager.popBackStack(backStackList[backStackSize - 2].stateTag, 0)
                bnvMain.selectedItemId = backStackList[backStackSize - 2].icon
                backStackList.removeAt(backStackSize - 1)
            }

            backStackSize == 1 -> {
                supportFragmentManager.popBackStack(TAG_BSS_MAIN, 0)
                bnvMain.selectedItemId = R.id.navigation_home
                backStackList.clear()
            }

            backStackSize == 0 -> {
                finish()
            }
        }
    }

    companion object {
        // FRAGMENT TAG CONSTANTS
        const val TAG_FRAGMENT_HOME = "tag_home"
        const val TAG_FRAGMENT_TRENDING = "tag_trending"
        const val TAG_FRAGMENT_SUBSCRIPTIONS = "tag_subscriptions"
        const val TAG_FRAGMENT_INBOX = "tag_inbox"
        const val TAG_FRAGMENT_LIBRARY = "tag_library"

        // BACK STACK STATE TAG CONSTANTS
        // BSS -> Back Stack State
        const val TAG_BSS_MAIN = "tag_bss_main"
        const val TAG_BSS_HOME = "tag_bss_home"
        const val TAG_BSS_TRENDING = "tag_bss_trending"
        const val TAG_BSS_SUBSCRIPTIONS = "tag_bss_subscriptions"
        const val TAG_BSS_INBOX = "tag_bss_inbox"
        const val TAG_BSS_LIBRARY = "tag_bss_library"
    }
}
