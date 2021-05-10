package github.learn.movie.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import github.learn.core.data.Resource
import github.learn.movie.R
import github.learn.movie.databinding.FragmentTrendingMovieBinding
import github.learn.movie.ui.home.adapter.TrendingMovieAdapter
import github.learn.movie.ui.home.viewmodel.TrendingMovieViewModel

@AndroidEntryPoint
class TrendingMovieFragment : Fragment() {

    private val viewModel: TrendingMovieViewModel by viewModels()
    private val trendingMovieAdapter = TrendingMovieAdapter()

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
        retrieveData()
        binding.rvMovie.adapter = trendingMovieAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun retrieveData() {
        viewModel.movie.observe(viewLifecycleOwner) { movie->
            when(movie){
                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    movie.data?.let { trendingMovieAdapter.submitData(it) }
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.viewError.root.visibility = View.VISIBLE
                    binding.viewError.tvError.text = movie.message ?: getString(R.string.something_wrong)
                }
            }
        }
    }
}