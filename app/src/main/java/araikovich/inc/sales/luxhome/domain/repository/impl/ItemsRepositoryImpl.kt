package araikovich.inc.sales.luxhome.domain.repository.impl

import araikovich.inc.sales.luxhome.data.ItemModel
import araikovich.inc.sales.luxhome.domain.repository.ItemsRepository

class ItemsRepositoryImpl : ItemsRepository {

    override suspend fun getItems(): List<ItemModel> {
        return listOf(ItemModel(1, "", 0, ""))
    }

    override suspend fun sortItemsBy() {

    }
}