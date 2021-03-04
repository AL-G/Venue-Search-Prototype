package com.placesapiprototype.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.placesapiprototype.R
import com.placesapiprototype.data.model.Items
import com.placesapiprototype.data.model.Venue
import com.placesapiprototype.databinding.ItemRowBinding
import com.squareup.picasso.Picasso

class OutletRecyclerViewAdapter(private var context: Context?) :

    RecyclerView.Adapter<OutletRecyclerViewAdapter.ViewHolder>() {
    private var items: List<Items> = emptyList()
    private val iconDimensions = 64

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
        val venue: Venue = items[position].venue

        holder.bind(venue)
        with(holder.itemView) {
            tag = position
        }

        // clear the chips from reused view
        holder.chipGroup.removeAllViews()
        for (category in venue.categories) {
            val chip = Chip(holder.venueIcon.context)
            chip.text = category.name
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.primaryLightColor))
            chip.setTextColor(ContextCompat.getColor(context!!, R.color.primaryTextColor))
            chip.chipStrokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.primaryTextColor))
            chip.chipStrokeWidth = 5f
            holder.chipGroup.addView(chip)

            // if this is the primary category, set the main icon
            if (category.primary) {
                Picasso.get()
                    .load("""${category.icon.prefix}${iconDimensions}${category.icon.suffix}""")
                    .resize(56, 56)
                    .centerCrop()
                    .into(holder.venueIcon)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private var itemRowBinding: ItemRowBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        lateinit var venueIcon: ImageView
        lateinit var chipGroup: ChipGroup

        fun bind(venue: Venue) {
            venueIcon = itemRowBinding.venueIcon
            chipGroup = itemRowBinding.chipGroup
            itemRowBinding.setVariable(BR.venue, venue)
            itemRowBinding.executePendingBindings()
        }
    }

    fun setValues(value: List<Items>?) {
        if (value != null) {
            this.items = value
            notifyDataSetChanged()
        }
    }

}