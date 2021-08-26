package com.paliarmo.moviedb.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.paliarmo.moviedb.R
import com.paliarmo.moviedb.core.BasicData

class BasicAdapter<T : BasicData>(private val onClick: (T) -> Unit): ListAdapter<BasicData, BasicAdapter.BasicViewHolder<T>>(DiffCallback)  {


    class BasicViewHolder<T : BasicData>(itemView: View, val onClick: (T) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private var current: T? = null

        init {
            itemView.setOnClickListener {
                current?.let {
                    onClick(it)
                }
            }
        }

        fun bind(item: BasicData) {
            current = item as? T
            current?.let {
                (itemView as? AdapterBasicView<T>)?.apply(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder<T> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_film_view, parent, false)
        return BasicViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: BasicViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object DiffCallback : DiffUtil.ItemCallback<BasicData>() {
    override fun areItemsTheSame(oldItem: BasicData, newItem: BasicData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BasicData, newItem: BasicData): Boolean {
        return oldItem.getId() == newItem.getId()
    }
}