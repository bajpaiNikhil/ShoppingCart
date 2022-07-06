package com.example.shoppingcart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingcart.data.db.entities.ShoppingItem
import com.example.shoppingcart.data.repository.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: ShoppingRepository
):ViewModel() {
    fun viewModelUpsert(item: ShoppingItem){
        viewModelScope.launch {
            repository.upsert(item)
        }
    }
    fun viewModelDelete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllShoppingItem() = repository.getAllShoppingItem()
}