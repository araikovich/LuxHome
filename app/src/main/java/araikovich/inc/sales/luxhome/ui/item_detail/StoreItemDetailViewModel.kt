package araikovich.inc.sales.luxhome.ui.item_detail

import araikovich.inc.sales.luxhome.data.model.ItemDetailModel
import araikovich.inc.sales.luxhome.ui.core.BaseAction
import araikovich.inc.sales.luxhome.ui.core.BaseViewModel
import araikovich.inc.sales.luxhome.ui.core.BaseViewState

internal class StoreItemDetailViewModel :
    BaseViewModel<StoreItemDetailViewModel.ViewState, StoreItemDetailViewModel.Action>(ViewState()) {

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.ActionItemLoaded -> ViewState()
    }

    internal data class ViewState(
        val isLoading: Boolean = true
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        data class ActionItemLoaded(val item: ItemDetailModel) : Action()
    }
}