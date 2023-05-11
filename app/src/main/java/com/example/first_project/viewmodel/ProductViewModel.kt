package com.example.first_project.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.first_project.database.responsitory.ProductRepository
import com.example.first_project.model.Product
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : ViewModel() {
    private val productRepository: ProductRepository = ProductRepository(application)

    fun insertProduct(product: Product) = viewModelScope.launch {
        productRepository.insertProduct(product)
    }

    fun updateProduct(product: Product) = viewModelScope.launch {
        productRepository.updateProduct(product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch {
        productRepository.deleteProduct(product)
    }

    fun getAllProduct(): LiveData<List<Product>> = productRepository.getAllProducts()


    class ProductViewModelFactory(private val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
                return ProductViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }


}