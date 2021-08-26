package com.paliarmo.moviedb.framework.ui.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.paliarmo.moviedb.ScreenState
import com.paliarmo.moviedb.adapter.BasicAdapter
import com.paliarmo.moviedb.core.BasicData
import com.paliarmo.moviedb.databinding.MoviesListFragmentBinding
import com.paliarmo.moviedb.framework.model.entities.EMovie
import com.paliarmo.moviedb.framework.model.responses.RMoviesList
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment  : Fragment() {
    private val viewModel: MoviesListViewModel<RMoviesList> by viewModel()
    private var _binding: MoviesListFragmentBinding? = null
    private val binding get() = _binding!!


    private lateinit  var adapter: BasicAdapter<EMovie>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = BasicAdapter{ data -> adapterOnClick(data) }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MoviesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = Observer<ScreenState> { renderData(it) }
        viewLifecycleOwner.lifecycle.addObserver(viewModel)
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)

        with(binding) {
            mRecycler.adapter = adapter
            mRecycler.layoutManager = LinearLayoutManager(context)
            updateMoviesList.setOnClickListener { viewModel.getMoviesList() }
            viewModel.getMoviesList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderData(state: ScreenState) = with(binding) {
        when (state) {
            is ScreenState.Success<*> -> {
                mRecycler.visibility = View.VISIBLE
                emptyView.visibility = View.GONE
                loadingView.visibility = View.GONE
                val moviesResponse = state.data
                moviesResponse?.let {
                    setData(it)
                }
            }
            is ScreenState.Loading -> {
                mRecycler.visibility = View.GONE
                emptyView.visibility = View.GONE
                loadingView.visibility = View.VISIBLE
            }
            is ScreenState.Error -> {
                mRecycler.visibility = View.GONE
                emptyView.visibility = View.VISIBLE
                emptyReasonTitle.text = "При загрузки списка фильмов возникла ошибка..."
                loadingView.visibility = View.GONE
            }
        }
    }

    private fun setData(movies: RMoviesList) = with(binding) {
        var mutable = movies.data as MutableList<BasicData>
        adapter.submitList(mutable)
        adapter.notifyDataSetChanged()
    }

    private fun adapterOnClick(item: EMovie) {

    }

    companion object {
        fun newInstance() = MoviesListFragment()
    }
}