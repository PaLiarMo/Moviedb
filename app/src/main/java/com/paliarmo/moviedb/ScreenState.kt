package com.paliarmo.moviedb

import com.paliarmo.moviedb.core.BasicData
import com.paliarmo.moviedb.framework.model.responses.RMoviesList


sealed class ScreenState {
    data class Success<T: BasicData>(val data: RMoviesList) : ScreenState()
    data class Error(val error: Throwable) : ScreenState()
    object Loading : ScreenState()
}