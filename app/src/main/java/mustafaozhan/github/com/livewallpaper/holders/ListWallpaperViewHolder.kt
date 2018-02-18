package mustafaozhan.github.com.livewallpaper.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import mustafaozhan.github.com.livewallpaper.R
import mustafaozhan.github.com.livewallpaper.interfaces.ItemClickListener

/**
 * Created by Mustafa Ozhan on 2/18/18 at 8:14 PM on Arch Linux wit Love <3.
 */
class ListWallpaperViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val itemClickListenner: ItemClickListener? = null

    private var wallpaper: ImageView? = null

    init {
        itemView?.setOnClickListener(this)
        wallpaper = itemView?.findViewById(R.id.imageView)
    }

    override fun onClick(view: View?) {
        itemClickListenner?.onClick(view!!, adapterPosition)
    }
}