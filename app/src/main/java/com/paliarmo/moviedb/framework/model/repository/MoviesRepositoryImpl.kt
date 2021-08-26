package com.paliarmo.moviedb.framework.model.repository

import com.paliarmo.moviedb.framework.model.entities.EMovie
import com.paliarmo.moviedb.framework.model.responses.RMoviesList

class MoviesRepositoryImpl: MoviesRepository {
    override fun getMoviesListFromServer(): RMoviesList {
        var movies = ArrayList<EMovie>()
        movies.add(EMovie(id = 1, "Первый фильм", 4.5f))
        movies.add(EMovie(id = 2, "Второй фильм", 4.1f))
        movies.add(EMovie(id = 3, "Третий фильм", 2.1f))
        var mock = RMoviesList(movies)
        return mock
    }
}