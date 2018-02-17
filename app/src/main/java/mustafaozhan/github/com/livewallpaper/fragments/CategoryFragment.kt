package mustafaozhan.github.com.livewallpaper.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_category.*
import mustafaozhan.github.com.livewallpaper.R
import mustafaozhan.github.com.livewallpaper.common.Common
import mustafaozhan.github.com.livewallpaper.holders.CategoryViewHolder
import mustafaozhan.github.com.livewallpaper.interfaces.ItemClickListener
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
                Picasso.with(activity)
                        .load(model.imageLink)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.backgroundImage, object : Callback {
                            override fun onSuccess() {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }

                            override fun onError() {
                                Picasso.with(activity)
                                        .load(model.imageLink)
                                        .error(R.drawable.ic_error_black_24dp)
                                        .into(holder.backgroundImage, object : Callback {
                                            override fun onSuccess() {
                                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                            }

                                            override fun onError() {
                                                Log.d("Error:", "Couldn't fetch the picture")
                                            }

                                        })
                            }

                        })
                holder.categoryName?.text = model.name
                holder.setItemClickListener(object : ItemClickListener {
                    override fun onClick(view: View, position: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder? {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_category_item, parent, false)
                return CategoryViewHolder(itemView)
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        recyclerViewCategory.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(activity, 2)
        recyclerViewCategory.layoutManager = gridLayoutManager

        setCategory()

        return view
    }

    private fun setCategory() {
        adapter?.startListening()
        recyclerViewCategory.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        if (adapter != null)
            adapter!!.startListening()
    }

    override fun onStop() {
        if (adapter != null)
            adapter!!.stopListening()
        super.onStop()
    }

    override fun onResume() {
        if (adapter!=null){
            adapter!!.startListening()
        }
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}