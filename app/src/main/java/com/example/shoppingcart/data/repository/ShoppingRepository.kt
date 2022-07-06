package com.example.shoppingcart.data.repository

import com.example.shoppingcart.data.db.ShoppingDao
import com.example.shoppingcart.data.db.entities.ShoppingItem
import javax.inject.Inject

class ShoppingRepository @Inject constructor(
    private val shoppingDao : ShoppingDao
) {

    suspend fun upsert(item: ShoppingItem) = shoppingDao.upsert(item)

    suspend fun delete(item: ShoppingItem) = shoppingDao.delete(item)

    fun getAllShoppingItem() = shoppingDao.getAllShoppingItem()

}