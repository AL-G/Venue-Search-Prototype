package com.placesapiprototype.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.placesapiprototype.R
import com.placesapiprototype.data.model.Items
import com.placesapiprototype.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var myRecyclerViewAdapter: OutletRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.main_fragment, container, false)
        var viewDataBinding = MainFragmentBinding.bind(root).apply {
            vm = viewModel
        }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        this.myRecyclerViewAdapter = OutletRecyclerViewAdapter(context)
        viewDataBinding.venuesAdapter = myRecyclerViewAdapter

        // observe the venues live data in the view model
        viewModel.coffeeOutlets?.observe(this.viewLifecycleOwner, outletsObserver)

        return root
    }

    private var outletsObserver: Observer<List<Items>> =
        Observer<List<Items>> { t -> myRecyclerViewAdapter.setValues(t) }

}