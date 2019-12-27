package araikovich.inc.sales.luxhome.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import araikovich.inc.sales.luxhome.data.ItemModel
import araikovich.inc.sales.luxhome.domain.repository.ItemsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class StoreItemsViewModel(
    private val itemsRepository: ItemsRepository
) : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.IO.plus(job)

    fun getItems(onSuccess: (List<ItemModel>) -> (Unit)) {
        launch {
            val items = itemsRepository.getItems()
            withContext(Dispatchers.Main){
                onSuccess.invoke(items)
            }
        }
    }
}