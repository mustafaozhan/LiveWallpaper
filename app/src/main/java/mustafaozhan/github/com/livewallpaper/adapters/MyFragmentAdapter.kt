package mustafaozhan.github.com.livewallpaper.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Mustafa Ozhan on 2/8/18 at 1:11 PM on Arch Linux wit Love <3.
 */
class MyFragmentAdapter(private val fragmentManager: FragmentManager, private val context: Context?) : FragmentPagerAdapter(fragmentManager) {
    private val adapterContext = context


    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> CategoryFragment.getInstance()
            1 -> DailyPopularFragment.getInstance()
            2 -> RecentsFragment.getInstance()
            else -> null
        }
    }

    override fun getCount() = 3

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Category"
            1 -> "Daily Popular"
            2 -> "Recent"
            else -> ""
        }
    }
}