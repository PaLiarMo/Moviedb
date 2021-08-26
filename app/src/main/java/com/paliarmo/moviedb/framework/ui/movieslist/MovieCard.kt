package com.paliarmo.moviedb.framework.ui.movieslist

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.paliarmo.moviedb.R
import com.paliarmo.moviedb.adapter.AdapterBasicView
import com.paliarmo.moviedb.core.BasicData
import com.paliarmo.moviedb.framework.model.entities.EMovie

class MovieCard : CardView, AdapterBasicView<EMovie> {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    private var title: TextView? = null
    private var rate: TextView? = null
    private var image: ImageView? = null

    private fun initView(){
        if (title == null) { title = findViewById(R.id.movieName) }
        if (rate == null) { rate = findViewById(R.id.movieRate) }
    }

    override fun apply(data: EMovie) {
        initView()
        title?.text = data.title
        rate?.text = "${data.vote_average}"
    }


}