package com.example.shoppingcart.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppingcart.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class] ,
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao() : ShoppingDao
}