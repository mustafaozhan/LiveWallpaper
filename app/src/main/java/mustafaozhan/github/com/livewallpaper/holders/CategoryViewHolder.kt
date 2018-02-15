package mustafaozhan.github.com.livewallpaper.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import mustafaozhan.github.com.livewallpaper.interfaces.ItemClickListener

/**
 * Created by Mustafa Ozhan on 2/10/18 at 1:02 PM on Arch Linux wit Love <3.
 */
class CategoryViewHolder(private var itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private var itemClickListener: ItemClickListener? = null


    fun setItemClickListtener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener?.onClick(v!!, adapterPosition)
    }


}