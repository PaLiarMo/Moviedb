package com.paliarmo.moviedb.framework.ui.moviedetail
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paliarmo.moviedb.databinding.MovieDetailFragmentBinding

import com.paliarmo.moviedb.framework.model.entities.EMovie

class MoviesDetailFragment: Fragment() {
    private var movie:EMovie? = null
    private var _binding: MovieDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getParcelable(EXTRAS_MOVIE) as? EMovie
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMovieInfo()
    }

    private fun setMovieInfo() = with(binding){
        movie?.let { movie ->
            movieName.text = movie.title
            movieNameEng.text = movie.original_title
            movieRate.text = "${movie.vote_average}"
            movieDescription.text = movie.overview
            movieBudget.text = movie.budget.toString()
            movieGenre.text = movie.getMovieGenries()
            movieDuration.text = movie.getMovieDuration()
            movieReleaseDate.text = movie.release_date
            movieRevenue.text = movie.revenue.toString()
        }

    }

    companion object{
        private const val EXTRAS_MOVIE = "EXTRAS_MOVIE_PARAM"
        fun newInstance(movie: EMovie): MoviesDetailFragment{
            val fr = MoviesDetailFragment()
            val b = Bundle()
            b.putParcelable(EXTRAS_MOVIE, movie)
            fr.arguments = b
            return fr
        }
    }
}