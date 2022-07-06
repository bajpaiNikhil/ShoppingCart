package com.example.shoppingcart.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Shopping_items")
data class ShoppingItem(

    @ColumnInfo(name = "Item Name")
    val name : String ,

    @ColumnInfo(name = "Item Quantity")
    var quantity : Int

){
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null
}

