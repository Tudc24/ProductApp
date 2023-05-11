package com.example.first_project.database.responsitory

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.first_project.database.ProductDatabase
import com.example.first_project.database.dao.ProductDao
import com.example.first_project.model.Product

class ProductRepository(application: Application) {
    private val productDao: ProductDao

    init {
        val productDatabase: ProductDatabase = ProductDatabase.getInstance(application)
        productDao = productDatabase.getProductDao()
    }

    suspend fun insertProduct(product: Product) = productDao.insertProduct(product)
    suspend fun updateProduct(product: Product) = productDao.updateProduct(product)
    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

    fun getAllProducts():LiveData<List<Product>> = productDao.getAllProduct()


}