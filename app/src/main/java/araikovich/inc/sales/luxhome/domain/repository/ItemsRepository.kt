package araikovich.inc.sales.luxhome.domain.repository

import androidx.lifecycle.LiveData
import araikovich.inc.sales.luxhome.data.ItemModel

interface ItemsRepository {

    suspend fun getItems(): List<ItemModel>

    suspend fun sortItemsBy()
}