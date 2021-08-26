package com.paliarmo.moviedb.framework.model.entities

import android.os.Parcelable
import com.paliarmo.moviedb.core.BasicData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EGenre(private val id: Int = 0, var name: String): BasicData, Parcelable {
    override fun getId(): Int {
        return id
    }

}
