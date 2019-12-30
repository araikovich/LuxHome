package araikovich.inc.sales.luxhome.ui.item_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import araikovich.inc.sales.luxhome.R
import araikovich.inc.sales.luxhome.databinding.FragmentItemDetailBinding

class StoreItemDetailFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_detail, container, false)
        binding = DataBindingUtil.bind(view)!!
        return view
    }
}