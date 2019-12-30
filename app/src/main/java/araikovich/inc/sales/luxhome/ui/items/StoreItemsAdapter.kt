package araikovich.inc.sales.luxhome.ui.items

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.inc.sales.luxhome.R
import araikovich.inc.sales.luxhome.data.model.ItemModel
import araikovich.inc.sales.luxhome.databinding.CellStoreItemBinding
import araikovich.inc.sales.luxhome.ui.util.DiffDefaultCallback

class StoreItemsAdapter(
    private val context: Context,
    private val onClick: (ItemModel) -> Unit,
    private val onBookmarkClick: (ItemModel) -> Unit
) : RecyclerView.Adapter<StoreItemsAdapter.ItemViewHolder>() {

    private val items: MutableList<ItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cell_store_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemModel = items[position]
        holder.setBookmarkedImage(items[position].isBookmarked)
        holder.setLiseteners(onClick = onClick, onBookmarkClick = onBookmarkClick)
    }

    fun updateItems(newList: List<ItemModel>) {
        val diffResult = DiffUtil.calculateDiff(DiffDefaultCallback(newList, items))
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = DataBindingUtil.bind<CellStoreItemBinding>(view)!!
        lateinit var itemModel: ItemModel

        fun setLiseteners(
            onClick: (ItemModel) -> Unit,
            onBookmarkClick: (ItemModel) -> Unit
        ) {
            binding.parentCard.setOnClickListener {
                onClick.invoke(itemModel)
            }
            binding.ivBookmark.setOnClickListener {
                itemModel.isBookmarked = !itemModel.isBookmarked
                setBookmarkedImage(itemModel.isBookmarked)
                onBookmarkClick.invoke(itemModel)
            }
        }

        fun setBookmarkedImage(isBookmarked: Boolean) {
            binding.ivBookmark.setImageResource(
                if (isBookmarked) {
                    R.drawable.ic_bookmarks
                } else {
                    R.drawable.ic_bookmarks_not_selected
                }
            )
        }
    }
}