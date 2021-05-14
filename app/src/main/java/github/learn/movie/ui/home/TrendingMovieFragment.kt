package github.learn.movie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.databinding.FragmentTrendingMovieBinding
import github.learn.movie.model.Movie
import github.learn.movie.ui.home.adapter.TrendingMovieAdapter
import github.learn.movie.ui.home.viewmodel.TrendingMovieViewModel
import github.learn.movie.utils.GridSpacingItemDecoration


@AndroidEntryPoint
class TrendingMovieFragment : Fragment() {

    private val viewModel: TrendingMovieViewModel by viewModels()
    private val adapter = TrendingMovieAdapter()

    private var _binding: FragmentTrendingMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrendingMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movies = viewModel.getTrendingMovie()
        initRecycler(movies)
    }

    private fun initRecycler(movies: List<Movie>) {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)
        binding.rvMovie.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
        binding.rvMovie.adapter = adapter
        adapter.submitData(movies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}