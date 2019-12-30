package araikovich.inc.sales.luxhome.data.model

data class ItemModel(
    val id: Int,
    val title: String,
    val price: Int,
    val image: String,
    var isBookmarked: Boolean = false
)