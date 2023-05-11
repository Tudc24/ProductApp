package com.example.first_project.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_project.R
import com.example.first_project.adapter.ProductAdapter
import com.example.first_project.model.Product
import com.example.first_project.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by lazy {
        ViewModelProvider(
            this,
            ProductViewModel.ProductViewModelFactory(this.application)
        )[ProductViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
        initEvents()
    }

    private fun initEvents() {
        btn_add_open.setOnClickListener {
            val intent = Intent(this,AddProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter: ProductAdapter = ProductAdapter(this@MainActivity,onItemClick,onItemDelete)

        rv_product.setHasFixedSize(true)
        rv_product.layoutManager=LinearLayoutManager(this)
        rv_product.adapter=adapter
        productViewModel.getAllProduct().observe(this, Observer{
            adapter.setProducts(it)
        })
    }

    private val onItemClick: (Product) -> Unit = {
        val intent = Intent(this,UpdateProductActivity::class.java)
        intent.putExtra("UPDATE_PRODUCT",it)
        startActivity(intent)
    }


    private val onItemDelete: (Product) -> Unit = {
        productViewModel.deleteProduct(it)
    }

}