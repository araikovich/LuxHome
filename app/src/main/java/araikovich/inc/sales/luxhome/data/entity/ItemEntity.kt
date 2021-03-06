package araikovich.inc.sales.luxhome.data.entity

import androidx.room.Entity

@Entity
data class ItemEntity(
    val id: Int,
    val title: String,
    val price: Int,
    val image: String
)