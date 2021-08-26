package com.paliarmo.moviedb.framework.ui.movieslist

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paliarmo.moviedb.ScreenState
import com.paliarmo.moviedb.core.BasicData
import com.paliarmo.moviedb.framework.model.repository.MoviesRepository
import kotlin.random.Random

class MoviesListViewModel<T: BasicData>(private val repository: MoviesRepository) : ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<ScreenState> = MutableLiveData()
    fun getLiveData() = liveDataToObserve

    fun getMoviesList() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = ScreenState.Loading
        Thread {
            Thread.sleep(2000)
            var susses = Random.nextBoolean()
            if (susses){
                liveDataToObserve.postValue(ScreenState.Success<T>(repository.getMoviesListFromServer()))
            }else{
                liveDataToObserve.postValue(ScreenState.Error(Throwable()))
            }

        }.start()
    }
}