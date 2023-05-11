package com.example.first_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.first_project.R
import com.example.first_project.model.Product
import com.example.first_project.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by lazy {
        ViewModelProvider(
            this,
            ProductViewModel.ProductViewModelFactory(this.application)
        )[ProductViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        btn_add.setOnClickListener {
            val product = Product(edt_product_title.text.toString(),edt_product_description.text.toString())
            productViewModel.insertProduct(product)
            finish()
        }
    }
}