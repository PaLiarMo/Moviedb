package com.paliarmo.moviedb.framework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paliarmo.moviedb.R
import com.paliarmo.moviedb.framework.ui.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesListFragment.newInstance())
                .commitNow()
        }
    }
}