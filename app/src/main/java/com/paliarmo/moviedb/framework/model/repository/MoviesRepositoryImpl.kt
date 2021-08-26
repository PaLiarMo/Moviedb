package com.paliarmo.moviedb.framework.model.repository

import com.paliarmo.moviedb.framework.model.entities.EMovie
import com.paliarmo.moviedb.framework.model.responses.RMoviesList

class MoviesRepositoryImpl: MoviesRepository {
    override fun getMoviesListFromServer(): RMoviesList {
        val movies = ArrayList<EMovie>()

        val movie1 = EMovie(id = 1, "Первый фильм", 4.5f)
        movie1.original_title = "First movie"
        movie1.budget = 2000000
        movie1.overview = "Детальное описание фильма"
        movie1.revenue = 30000403
        movie1.release_date = "20 октября 2020"

        movies.add(movie1)
        movies.add(EMovie(id = 2, "Второй фильм", 4.1f))
        movies.add(EMovie(id = 3, "Третий фильм", 2.1f))
        val mock = RMoviesList(movies)
        return mock
    }
}