package araikovich.inc.sales.luxhome.ui.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import araikovich.inc.sales.luxhome.MainActivity
import araikovich.inc.sales.luxhome.R
import araikovich.inc.sales.luxhome.data.model.ItemModel
import araikovich.inc.sales.luxhome.databinding.FragmentStoreItemsBinding
import araikovich.inc.sales.luxhome.ui.util.ItemsDecorator
import araikovich.inc.sales.luxhome.ui.util.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoreItemsFragment : Fragment() {

    private val viewModel: StoreItemsViewModel by viewModel()
    private val adapter by lazy { StoreItemsAdapter(context!!, onItemClick, onBooked) }
    private lateinit var binding: FragmentStoreItemsBinding

    private val stateObserver = Observer<StoreItemsViewModel.ViewState> {
        adapter.updateItems(it.items)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store_items, container, false)
        binding = DataBindingUtil.bind(view)!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdaper()
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.getItems()
    }

    private fun setupAdaper() {
        binding.rvItems.apply {
            layoutManager = GridLayoutManager(context!!, 2, GridLayoutManager.VERTICAL, false)
            adapter = this@StoreItemsFragment.adapter
            addItemDecoration(ItemsDecorator(context!!))
        }
    }

    private val onItemClick: (ItemModel) -> Unit = { item ->
        (activity as MainActivity).toDetailFragment(item.id)
    }

    private val onBooked: (ItemModel) -> Unit = { item ->
        // TODO Add to booked database
    }
}