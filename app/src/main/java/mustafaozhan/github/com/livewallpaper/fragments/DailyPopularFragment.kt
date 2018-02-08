package mustafaozhan.github.com.livewallpaper.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import mustafaozhan.github.com.livewallpaper.R

/**
 * Created by Mustafa Ozhan on 2/8/18 at 1:36 PM on Arch Linux wit Love <3.
 */
class DailyPopularFragment:Fragment(){
    companion object {
        private var INSTANCE: DailyPopularFragment? = null
        fun getInstance(): DailyPopularFragment? {
            if (INSTANCE == null)
                INSTANCE = DailyPopularFragment()
            return INSTANCE

        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_daily_popular, container, false)
}