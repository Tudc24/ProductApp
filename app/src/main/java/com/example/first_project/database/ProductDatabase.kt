package com.example.first_project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.first_project.database.dao.ProductDao
import com.example.first_project.model.Product


@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao

    companion object{
        @Volatile
        private var instance: ProductDatabase?=null
        fun getInstance(context: Context): ProductDatabase{
            if(instance==null){
                instance=Room.databaseBuilder(context,ProductDatabase::class.java,"ProductDatabase").build()
            }
            return instance!!

        }
    }
}