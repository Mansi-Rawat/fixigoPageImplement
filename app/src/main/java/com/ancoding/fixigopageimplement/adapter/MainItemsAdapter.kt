package com.ancoding.fixigopageimplement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ancoding.fixigopageimplement.OnItemClickListener
import com.ancoding.fixigopageimplement.R
import com.ancoding.fixigopageimplement.models.CheckItem

class MainItemsAdapter(
    private val mList: List<CheckItem>, private val listener: OnItemClickListener
) : RecyclerView.Adapter<MainItemsAdapter.MainItemsHolder>() {
    lateinit var context: Context

    inner class MainItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var tvAmount: TextView = itemView.findViewById(R.id.tvAmount)

        var tvServiceName: TextView = itemView.findViewById(R.id.tvServiceName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemsHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_added, parent, false)
        context = parent.context
        return MainItemsHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainItemsHolder, position: Int) {
        val item = mList[position]

        holder.tvQuantity.text = item.quantity.toString()
        holder.tvAmount.text = item.price.toString()
        holder.tvDate.text = item.date.toString()
        holder.tvServiceName.text=item.name.toString()
        holder.tvDate.setOnClickListener {
            listener.onItemClick(position)
        }
    }
    override fun getItemCount(): Int {
        return mList.size
    }
}