package com.paliarmo.moviedb.framework.model.repository

import com.paliarmo.moviedb.framework.model.responses.RMoviesList

interface MoviesRepository {
    fun getMoviesListFromServer(): RMoviesList
}