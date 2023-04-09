package com.lit.oryxrecyclerview


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// This is an Adapter that Creates The data to Put in Our Recycler View.
class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // Array of Food titles
    private val titles = arrayOf("Breakfast",
            "Fish Fillet", "Teabreak", "Snacks",
            "Chinese", "Spaghetti", "Rice",
            "Freshy")
    // Array of Food Details
    private val details = arrayOf("Item one details This is Nice Food", "Item two details This is Nice Food",
            "Item three details This is Nice Food", "Item four details This is Nice Food",
            "Item file details This is Nice Food", "Item six details This is Nice Food",
            "Item seven details  This is Nice Food", "Item eight details  This is Nice Food")
    // Array of Food costs
    private val cost = arrayOf("1,300KES", "1,100KES", "200KES", "1200KES",
        "800KES", "100KES", "300KES", "250KES")

    // Array of Food images
    private val images = intArrayOf(R.drawable.food1,
                  R.drawable.food2, R.drawable.food3,
                  R.drawable.food4, R.drawable.food5,
                  R.drawable.food6, R.drawable.food7,
                  R.drawable.food8)

    // Access the Single item XML Layout
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singleitem, viewGroup, false)
        return ViewHolder(v)
    }

    //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCost: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemCost = itemView.findViewById(R.id.item_cost)

        }
    }

    //Set Items from Arrays and Put/Bind them in respectives Views
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemCost.text = cost[i]
        //Below to be Done At the End to demonstrate how to move to Next Page on Item Click
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(context, "Item Position"+i, Toast.LENGTH_SHORT).show()
            if(i == 0) {
                val x = Intent(context, Breakfast::class.java)
                x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(x)
            }
            //Other Positions here.

        }
    }

    // Get how many items the array have, All arrays must have equal sizes
    override fun getItemCount(): Int {
        return titles.size
    }
}