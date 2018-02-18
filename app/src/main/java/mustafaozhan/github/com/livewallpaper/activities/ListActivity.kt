package mustafaozhan.github.com.livewallpaper.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list.*
import mustafaozhan.github.com.livewallpaper.R
import mustafaozhan.github.com.livewallpaper.common.Common
import mustafaozhan.github.com.livewallpaper.holders.ListWallpaperViewHolder
import mustafaozhan.github.com.livewallpaper.interfaces.ItemClickListener
import mustafaozhan.github.com.livewallpaper.model.WallpaperItem

class ListActivity : AppCompatActivity() {

    var query: Query? = null
    var options: FirebaseRecyclerOptions<WallpaperItem>? = null
    var adapter: FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mToolbar.title = Common.CATEGORY_SELECTED
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        mRecyclerList.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2)
        mRecyclerList.layoutManager = gridLayoutManager

        loadBackgroundList()
    }

    private fun loadBackgroundList() {
        query = FirebaseDatabase.getInstance().getReference(Common.STR_WALLPAPER)
                .orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED)
        options = FirebaseRecyclerOptions.Builder<WallpaperItem>()
                .setQuery(query!!, WallpaperItem::class.java)
                .build()

        adapter = object : FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>(options!!) {
            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListWallpaperViewHolder {
                val itemView = LayoutInflater.from(parent!!.context)
                        .inflate(R.layout.layout_wallpaper_item, parent, false)

                val height = parent.measuredHeight / 2
                return ListWallpaperViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: ListWallpaperViewHolder, position: Int, model: WallpaperItem) {
                Picasso.with(baseContext)
                        .load(model.imageLink)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.wallpaper,object : Callback {
                            override fun onSuccess() {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }

                            override fun onError() {
                                Picasso.with(baseContext)
                                        .load(model.imageLink)
                                        .networkPolicy(NetworkPolicy.OFFLINE)
                                        .error(R.drawable.ic_error_black_24dp)
                                        .into(holder.wallpaper,object :Callback{
                                            override fun onSuccess() {
                                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                            }

                                            override fun onError() {
                                               Log.d("Error:","could not fetch the image")
                                            }

                                        })
                            }

                        })
                holder.setItemClickListener(object :ItemClickListener{
                    override fun onClick(view: View, position: Int) {

                    }

                })
            }


        }
        (adapter as FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>).startListening()


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
        super.onResume()
        if (adapter != null) {
            adapter!!.startListening()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
