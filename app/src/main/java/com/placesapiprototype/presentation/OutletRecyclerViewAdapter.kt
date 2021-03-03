package com.placesapiprototype.presentation

import ResponseBase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.placesapiprototype.R
import com.placesapiprototype.databinding.ItemRowBinding

class OutletRecyclerViewAdapter(var listener: View.OnClickListener) :

    RecyclerView.Adapter<OutletRecyclerViewAdapter.ViewHolder>() {

    lateinit var response: ResponseBase

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_row, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val dataModel: VenueB = response.response.groups[0].items[position].venue as VenueB

        //holder.bind(dataModel)
        with(holder.itemView) {
            tag = position
            setOnClickListener(listener)
        }
//        if (dataModel.image[0].text.isNotEmpty()) {
//            Picasso.get()
//                .load(dataModel.image[0].text)
//                .resize(50, 50)
//                .centerCrop()
//                .into(holder.albumImage)
//        }
    }

    override fun getItemCount(): Int {
        return response.response.groups[0].items.size
    }

    inner class ViewHolder(private var itemRowBinding: ItemRowBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {

        // lateinit var albumImage: ImageView

        fun bind(obj: Any?) {
            //itemRowBinding.artistCardView.setOnClickListener(listener)
            //albumImage = itemRowBinding.albumImage
            //itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }

    }

    fun setValues(value: ResponseBase?) {
        if (value != null) {
            //this.response.clear()
            this.response = value
            notifyDataSetChanged()
        }
    }

}