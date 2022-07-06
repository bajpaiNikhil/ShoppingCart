package com.example.shoppingcart.di.module

import android.content.Context
import androidx.room.Room
import com.example.shoppingcart.data.db.ShoppingDao
import com.example.shoppingcart.data.db.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext app: Context
    ): ShoppingDatabase {
        return Room.databaseBuilder(
            app ,
            ShoppingDatabase::class.java ,
            "ShoppingDatabase.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDatabaseDao(db:ShoppingDatabase): ShoppingDao = db.getShoppingDao()

}