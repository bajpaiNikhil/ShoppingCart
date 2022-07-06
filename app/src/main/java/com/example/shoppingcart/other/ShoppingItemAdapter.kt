package com.example.shoppingcart.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.data.db.entities.ShoppingItem
import com.example.shoppingcart.databinding.ShoppingItemBinding
import com.example.shoppingcart.viewModel.ShoppingViewModel


class ShoppingItemAdapter(var item : List<ShoppingItem>, private val viewModel: ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding =  ShoppingItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = item[position]

        with(holder){
            with(item[position]){
                binding.tvName.text = currentItem.name
                binding.tvAmount.text = currentItem.quantity.toString()
            }
        }

        holder.binding.ivDelete.setOnClickListener {
            viewModel.viewModelDelete(currentItem)
        }

        holder.binding.ivMinus.setOnClickListener {
            if(currentItem.quantity>0){
                currentItem.quantity--
                viewModel.viewModelUpsert(currentItem)
            }
        }

        holder.binding.ivPlus.setOnClickListener {
            currentItem.quantity++
            viewModel.viewModelUpsert(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}