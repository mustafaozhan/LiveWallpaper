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
    private var itemClickListener: ItemClickListener? = null

     var wallpaper: ImageView? = null

    init {
        itemView?.setOnClickListener(this)
        wallpaper = itemView?.findViewById(R.id.image)
    }

    override fun onClick(view: View?) {
        itemClickListener?.onClick(view!!, adapterPosition)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}