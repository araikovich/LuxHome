package araikovich.inc.sales.luxhome.ui.util

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemsDecorator(private val context: Context) : RecyclerView.ItemDecoration() {

    companion object {
        const val CARD_PADDING_IN_DP = 8f
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        val paddingForItem = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            CARD_PADDING_IN_DP,
            context.resources.displayMetrics
        )
        if (position % 2 == 0) {
            outRect.set(paddingForItem.div(1).toInt(), 0, 0, paddingForItem.toInt())
        } else {
            outRect.set(
                paddingForItem.div(1).toInt(),
                0,
                paddingForItem.div(1).toInt(),
                paddingForItem.toInt()
            )
        }
    }
}