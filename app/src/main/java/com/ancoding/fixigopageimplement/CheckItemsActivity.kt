package com.ancoding.fixigopageimplement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ancoding.fixigopageimplement.adapter.CheckItemsAdapter
import com.ancoding.fixigopageimplement.models.CheckItem
import com.ancoding.fixigopageimplement.databinding.ActivityCheckItemsBinding


class CheckItemsActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityCheckItemsBinding
    private lateinit var adapter: CheckItemsAdapter
    private val checkList = ArrayList<CheckItem>()
    private val selectedItems = ArrayList<CheckItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createCheckList()
        setAdapter()
        addOnClickListeners()
    }
    private fun addOnClickListeners() {
        binding.tvAdd.setOnClickListener {

            for (i in checkList) {
                if (i.isSelected) {
                    selectedItems.add(i)
                }
            }
            val resultIntent = Intent()
            resultIntent.putExtra("selectedItems", selectedItems)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun setAdapter() {
        adapter = CheckItemsAdapter(checkList, this)
        binding.rVSelectedItems.adapter = adapter
    }

    private fun createCheckList() {
        for (i in 1..20) {
            checkList.add(CheckItem("Mansi", i, i * 10))
        }
    }

    override fun onItemClick(position: Int, isSelected: Boolean?) {
        checkList[position].isSelected = !(isSelected?:false)
        adapter.notifyItemChanged(position)
    }

}