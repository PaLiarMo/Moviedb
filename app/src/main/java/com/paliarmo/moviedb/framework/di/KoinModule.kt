package com.paliarmo.moviedb.framework.di

import com.paliarmo.moviedb.framework.model.repository.MoviesRepository
import com.paliarmo.moviedb.framework.model.repository.MoviesRepositoryImpl
import com.paliarmo.moviedb.framework.model.responses.RMoviesList
import com.paliarmo.moviedb.framework.ui.movieslist.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl() }

//    //View models
    viewModel { MoviesListViewModel<RMoviesList>(get()) }
}