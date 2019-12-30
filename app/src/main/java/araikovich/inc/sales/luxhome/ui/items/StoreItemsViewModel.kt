package araikovich.inc.sales.luxhome.ui.items

import araikovich.inc.sales.luxhome.data.model.ItemModel
import araikovich.inc.sales.luxhome.domain.repository.ItemsRepository
import araikovich.inc.sales.luxhome.ui.core.BaseAction
import araikovich.inc.sales.luxhome.ui.core.BaseViewModel
import araikovich.inc.sales.luxhome.ui.core.BaseViewState
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

internal class StoreItemsViewModel(
    private val itemsRepository: ItemsRepository
) : BaseViewModel<StoreItemsViewModel.ViewState, StoreItemsViewModel.Action>(ViewState()),
    CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.IO.plus(job)

    fun getItems() {
        launch {
            val items = itemsRepository.getItems()
            withContext(Dispatchers.Main) {
                sendAction(Action.ItemsLoadSuccess(items))
            }
        }
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.ItemsLoadSuccess -> {
            ViewState(
                isLoading = false,
                isError = false,
                items = viewAction.items
            )
        }
        is Action.ItemsLoadFailed -> {
            ViewState(
                isLoading = false,
                isError = false,
                items = mutableListOf()
            )
        }
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val items: List<ItemModel> = mutableListOf()
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class ItemsLoadSuccess(val items: List<ItemModel>) : Action()
        object ItemsLoadFailed : Action()
    }
}