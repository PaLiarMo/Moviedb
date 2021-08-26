package com.paliarmo.moviedb.framework.model.entities

import com.paliarmo.moviedb.core.BasicData

data class EMovie(
    private val id: Int = 0,
    var title: String,
    var vote_average: Float,

    var imdb_id: String? = null,
    var adult: Boolean? = null,
    var backdrop_path: String = "",
    var budget: UInt? = null,
    var homepage: String = "",
    var overview: String = "",

    var poster_path: String = "",
    var release_date:String = ""

): BasicData{
    override fun getId(): Int {
        return id
    }

}