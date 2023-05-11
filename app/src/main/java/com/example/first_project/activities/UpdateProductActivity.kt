package com.example.first_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.first_project.R
import com.example.first_project.model.Product
import com.example.first_project.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_update_product.*

class UpdateProductActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by lazy {
        ViewModelProvider(
            this,
            ProductViewModel.ProductViewModelFactory(this.application)
        )[ProductViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_product)

        val product = intent.getSerializableExtra("UPDATE_PRODUCT") as Product
        edt_product_title.setText(product.title)
        edt_product_description.setText(product.description)

        btn_update.setOnClickListener {
            product.title= edt_product_title.text.toString()
            product.description=edt_product_description.text.toString()
            productViewModel.updateProduct(product)
            finish()
        }
    }
}