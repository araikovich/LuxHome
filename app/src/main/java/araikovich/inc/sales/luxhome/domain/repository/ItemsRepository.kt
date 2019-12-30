package araikovich.inc.sales.luxhome.domain.repository

import araikovich.inc.sales.luxhome.data.model.ItemModel

interface ItemsRepository {

    suspend fun getItems(): List<ItemModel>

    suspend fun sortItemsBy()
}