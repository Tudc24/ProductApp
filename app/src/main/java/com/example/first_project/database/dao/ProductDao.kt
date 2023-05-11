package com.example.first_project.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.first_project.model.Product


@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("select * from product_table")
    fun getAllProduct(): LiveData<List<Product>>

//    @Query("select * from product_table where title_col=:title")
//    fun getProductByTitle(title: String): LiveData<List<Product>>
}