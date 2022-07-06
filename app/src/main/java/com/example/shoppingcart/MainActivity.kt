package com.example.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingcart.data.db.entities.ShoppingItem
import com.example.shoppingcart.databinding.ActivityMainBinding
import com.example.shoppingcart.other.ShoppingItemAdapter
import com.example.shoppingcart.viewModel.ShoppingViewModel
import com.example.shoppinglist.ui.shoppinglist.AddDialogListener
import com.example.shoppinglist.ui.shoppinglist.AddShoppingItemDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel : ShoppingViewModel by viewModels()
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "ShoppingCart"
        //val viewModel : ShoppingViewModel by viewModels()
        viewModel.getAllShoppingItem().observe(this , Observer {
            binding.rView.layoutManager = LinearLayoutManager(this)
            binding.rView.adapter = ShoppingItemAdapter(it , viewModel)
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add( 0 ,0,0,"Add")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Add" ->{
                AddShoppingItemDialog(
                    this ,
                    object :AddDialogListener{
                        override fun onAddButtonClicked(item: ShoppingItem) {
                            viewModel.viewModelUpsert(item)
                        }
                    }
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}