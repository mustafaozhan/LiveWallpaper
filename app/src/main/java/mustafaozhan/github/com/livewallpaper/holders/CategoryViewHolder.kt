package mustafaozhan.github.com.livewallpaper.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.layout_category_item.view.*
import mustafaozhan.github.com.livewallpaper.R
import mustafaozhan.github.com.livewallpaper.interfaces.ItemClickListener

/**
 * Created by Mustafa Ozhan on 2/10/18 at 1:02 PM on Arch Linux wit Love <3.
 */
class CategoryViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private var itemClickListener: ItemClickListener? = null
    var backgroundImage: ImageView? = null
    var categoryName: TextView? = null

    init {
        itemView?.setOnClickListener(this)
        backgroundImage = itemView?.findViewById(R.id.img)
        categoryName = itemView?.findViewById(R.id.txtName)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener?.onClick(v!!, adapterPosition)
    }


}