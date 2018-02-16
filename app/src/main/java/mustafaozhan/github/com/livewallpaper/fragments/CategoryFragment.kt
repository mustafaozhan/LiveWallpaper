package mustafaozhan.github.com.livewallpaper.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import mustafaozhan.github.com.livewallpaper.R
import mustafaozhan.github.com.livewallpaper.common.Common
import mustafaozhan.github.com.livewallpaper.holders.CategoryViewHolder
import mustafaozhan.github.com.livewallpaper.model.CategoryItem

/**
 * Created by Mustafa Ozhan on 2/8/18 at 1:36 PM on Arch Linux wit Love <3.
 */
class CategoryFragment : Fragment() {

    private var database: FirebaseDatabase? = null
    private var categoryBackground: DatabaseReference? = null

    private var options: FirebaseRecyclerOptions<CategoryItem>? = null
    private var adapter: FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>? = null

    init {
        database = FirebaseDatabase.getInstance()
        categoryBackground = database!!.getReference(Common.STR_CATEGORY_BACKGROUND)

        options = FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackground!!, CategoryItem::class.java)
                .build()

        adapter = object : FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options!!) {
            override fun onBindViewHolder(holder: CategoryViewHolder, position: Int, model: CategoryItem) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder? {
                return null
            }
        }

    }

    companion object {
        private var INSTANCE: CategoryFragment? = null
        fun getInstance(): CategoryFragment? {
            if (INSTANCE == null)
                INSTANCE = CategoryFragment()
            return INSTANCE

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_category, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}