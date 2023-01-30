package com.ancoding.fixigopageimplement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ancoding.fixigopageimplement.OnItemClickListener
import com.ancoding.fixigopageimplement.R
import com.ancoding.fixigopageimplement.models.CheckItem

class CheckItemsAdapter(
    private val mList: List<CheckItem>, private val listener: OnItemClickListener
) : RecyclerView.Adapter<CheckItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_check, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        holder.tvService?.text = item.name
        holder.tvQuantity?.text = item.quantity.toString()
        holder.tvPrice?.text = item.price.toString()
        holder.checkBox?.isSelected = item.isSelected

        holder.checkBox?.setOnClickListener {
            holder.checkBox.isSelected = !item.isSelected
            listener.onItemClick(position, item.isSelected)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuantity: TextView? = view.findViewById(R.id.tvQuantity)
        val tvService: TextView? = view.findViewById(R.id.tvService)
        val tvPrice: TextView? = view.findViewById(R.id.tvPrice)
        val checkBox: CheckBox? = view.findViewById(R.id.checkBox)
    }



}

