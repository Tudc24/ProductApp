package com.example.first_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.first_project.R
import com.example.first_project.model.Product

class ProductAdapter(
    private val context: Context,
    private val onClick: (Product) -> Unit,
    private val onDelete: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var products: List<Product> = listOf()

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_item_title)
        private val txtDescription: TextView = itemView.findViewById(R.id.txt_item_description)
        private val btnDelete:ImageView = itemView.findViewById(R.id.btn_delete)
        private val layoutItem:ConstraintLayout = itemView.findViewById(R.id.layout_item)
        fun onBind(product: Product) {
            txtTitle.text = product.title
            txtDescription.text = product.description
            //click
            btnDelete.setOnClickListener{ onDelete(product)}
            layoutItem.setOnClickListener { onClick(product) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setProducts(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

}