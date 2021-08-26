package com.paliarmo.moviedb.framework.model.entities

import android.os.Parcelable
import com.paliarmo.moviedb.core.BasicData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EMovie(
    private val id: Int = 0,
    var title: String,
    var vote_average: Float,

): BasicData, Parcelable{

    var adult : Boolean? = null
    var backdrop_path : String = ""
    var belongs_to_collection : String = ""
    var budget : Int = 0
    var genres : List<EGenre>? = null
    var homepage : String = ""
    var imdb_id : String = ""
    var original_language : String = ""
    var original_title : String = ""
    var overview : String = ""
    var popularity : Double = 0.0
    var poster_path : String = ""
//    val production_companies : List<Production_companies>,
//    val production_countries : List<Production_countries>,
    var release_date : String = ""
    var revenue : Int = 0
    private var runtime : Int = 0
//    val spoken_languages : List<Spoken_languages>,
    var status : String = ""
    var tagline : String = ""
    var video : Boolean = false
    var vote_count : Int = 0

    fun getMovieGenries(): String{
        //TODO GET GENRIES LIST
        return ""
    }

    fun getMovieDuration(): String{
        //TODO FORMAT DATE
        return runtime.toString()
    }

    override fun getId(): Int {
        return id
    }

}