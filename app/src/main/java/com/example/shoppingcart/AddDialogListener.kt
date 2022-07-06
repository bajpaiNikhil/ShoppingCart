package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppingcart.data.db.entities.ShoppingItem


interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}