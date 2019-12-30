package araikovich.inc.sales.luxhome.data.model

data class ItemDetailModel(
    val id: Int,
    val image: String,
    val title: String,
    val sizes: List<Int>,
    val price: Int,
    val priceWithoutSale: Int,
    val rating: Int,
    val feedbackCount: Int,
    val vendorCode: String,
    val composition: List<String>,
    val relatedItems: List<ItemModel>
)