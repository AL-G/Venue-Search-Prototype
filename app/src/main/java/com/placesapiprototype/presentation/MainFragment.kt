package com.placesapiprototype.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.placesapiprototype.R
import com.placesapiprototype.databinding.MainFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : Fragment() {

//    companion object {
//        fun newInstance() = MainFragment()
//    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var viewDataBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val root = inflater.inflate(R.layout.main_fragment, container, false)
        //val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
////        this.viewModel = MainViewModel(GetCoffeeOutletsUseCase(RepositoryImpl(RemoteDataSource(
////            providePlacesApiService()
////        ))))
//        viewDataBinding = MainFragmentBinding.bind(root).apply {
//            this.viewmodel
//        }
//        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
//
//        return viewDataBinding.root


//        val binding: MainFragmentBinding = DataBindingUtil.inflate(
//            inflater, R.layout.main_fragment, container, false
//        )
//
//        //here data must be an instance of the class MarsDataProvider
//        //here data must be an instance of the class MarsDataProvider
//        //binding.setMarsdata(data)
//        return binding.root
        return MainFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel    // Attach your view model here
        }.root
    }



}