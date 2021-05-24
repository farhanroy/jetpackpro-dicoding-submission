package github.learn.movie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.databinding.FragmentTrendingMovieBinding
import github.learn.movie.ui.detail.DetailMovieActivity
import github.learn.movie.ui.home.adapter.TrendingMovieAdapter
import github.learn.movie.ui.home.viewmodel.TrendingMovieViewModel
import github.learn.movie.utils.GridSpacingItemDecoration


@AndroidEntryPoint
class TrendingMovieFragment : Fragment() {

    private val viewModel: TrendingMovieViewModel by viewModels()
    private lateinit var adapter : TrendingMovieAdapter

    private var _binding: FragmentTrendingMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrendingMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeLiveData() {
        viewModel.getTrendingMovie().observe(viewLifecycleOwner) { movies ->
            initRecycler(movies = movies)
        }
    }

    private fun initRecycler(movies: List<MovieEntity>) {
        adapter = TrendingMovieAdapter { movie ->
            requireActivity().startActivity(DetailMovieActivity.newIntent(requireActivity(), movie))
        }
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)
        binding.rvMovie.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
        binding.rvMovie.adapter = adapter
        adapter.submitData(movies)
    }
}