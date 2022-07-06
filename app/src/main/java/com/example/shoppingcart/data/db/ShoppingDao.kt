package com.example.shoppingcart.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingcart.data.db.entities.ShoppingItem


@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item:ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM Shopping_items")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

}