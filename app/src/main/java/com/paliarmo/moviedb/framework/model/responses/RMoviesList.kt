package com.paliarmo.moviedb.framework.model.responses

import com.paliarmo.moviedb.core.BasicResponse
import com.paliarmo.moviedb.framework.model.entities.EMovie

data class RMoviesList(var data: ArrayList<EMovie>): BasicResponse {

    override fun getId(): Int {
        return 0
    }

    override fun count(): Int {
        return data.size
    }
}
