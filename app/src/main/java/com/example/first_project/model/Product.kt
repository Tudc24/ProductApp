package com.example.first_project.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "product_table")
class Product(
    @ColumnInfo(name = "title_col") var title: String = "",
    @ColumnInfo(name = "description_col") var description: String = ""
): Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id_col")
    var id: Int = 0

}