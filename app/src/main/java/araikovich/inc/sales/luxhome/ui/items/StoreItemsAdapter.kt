package araikovich.inc.sales.luxhome.ui.items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.sales.luxhome.R
import araikovich.inc.sales.luxhome.data.ItemModel
import araikovich.inc.sales.luxhome.databinding.CellStoreItemBinding
import araikovich.inc.sales.luxhome.ui.util.DiffDefaultCallback
import araikovich.inc.sales.luxhome.ui.util.color

class StoreItemsAdapter(
    private val context: Context
) : RecyclerView.Adapter<StoreItemsAdapter.ItemViewHolder>() {

    private val items: MutableList<ItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_store_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setBackgroundColor()
    }

    fun updateItems(newList: List<ItemModel>) {
        val diffResult = DiffUtil.calculateDiff(DiffDefaultCallback(newList, items))
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = DataBindingUtil.bind<CellStoreItemBinding>(view)!!

        fun setBackgroundColor() {
            binding.parentContainer.setBackgroundColor(binding.root.context.color(R.color.main_menu_item_color))
        }
    }
}