package com.ancoding.fixigopageimplement

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ancoding.fixigopageimplement.adapter.MainItemsAdapter
import com.ancoding.fixigopageimplement.databinding.ActivityMainBinding
import com.ancoding.fixigopageimplement.models.CheckItem
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener
     {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainItemsAdapter

    private val checkedItems = ArrayList<CheckItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        addOnClickListener()
    }

    private fun addOnClickListener() {
        binding.tvAdd.setOnClickListener {
            val intent = Intent(this, CheckItemsActivity::class.java)
            startActivityForResult(intent, 100)
        }
    }

    private fun setAdapter() {
        adapter = MainItemsAdapter(checkedItems, this)
        binding.rvAddedItems.adapter = adapter
    }


    override
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            100 -> {
                if (resultCode == RESULT_OK) {
                    val returnValue = data?.getSerializableExtra("selectedItems") as List<CheckItem>
                    checkedItems.addAll(returnValue)
                    adapter.notifyDataSetChanged()

                }
            }
        }
    }

    override fun onItemClick(position: Int, isSelected: Boolean?) {
        val calendar: Calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(
            this@MainActivity,
            { view, calYear, calMonth, dayOfMonth ->

                checkedItems[position].date= "$dayOfMonth-$calMonth-$calYear"
                adapter.notifyItemChanged(position)

            }, year, month, day
        )
        datePickerDialog.show()

    }
}

