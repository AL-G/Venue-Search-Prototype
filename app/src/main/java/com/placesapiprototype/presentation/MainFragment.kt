package com.placesapiprototype.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.placesapiprototype.R
import com.placesapiprototype.data.model.Items
import com.placesapiprototype.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var myRecyclerViewAdapter: OutletRecyclerViewAdapter
    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.main_fragment, container, false)
        val viewDataBinding = MainFragmentBinding.bind(root).apply {
            vm = viewModel
        }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        this.myRecyclerViewAdapter = OutletRecyclerViewAdapter(context)
        viewDataBinding.venuesAdapter = myRecyclerViewAdapter

        // observe the venues live data in the view model
        viewModel.coffeeOutlets?.observe(this.viewLifecycleOwner, outletsObserver)

        return root
    }

    override fun onStart() {
        super.onStart()
        requestNewLocationData()
    }

    private var outletsObserver: Observer<List<Items>> =
        Observer<List<Items>> { t -> myRecyclerViewAdapter.setValues(t) }


    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity as Activity)

        mFusedLocationClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            if (location != null) {
                viewModel.lat = location.latitude.toString()
                viewModel.long = location.longitude.toString()
                viewModel.refreshLocalCoffeeOutlets()

            }
        }
    }
}