package github.learn.movie.ui.home

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.databinding.FragmentTrendingMovieBinding
import github.learn.movie.ui.detail.DetailMovieActivity
import github.learn.movie.ui.home.adapter.TrendingMovieAdapter
import github.learn.movie.ui.home.viewmodel.TrendingMovieViewModel
import github.learn.movie.utils.Constants
import github.learn.movie.utils.GridSpacingItemDecoration
import github.learn.movie.utils.MarginItemDecoration
import github.learn.movie.utils.Status


@AndroidEntryPoint
class TrendingMovieFragment : Fragment(), TrendingMovieAdapter.OnItemClickCallback {

    private val viewModel: TrendingMovieViewModel by viewModels()

    private val mAdapter = TrendingMovieAdapter()
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
        observeData()
        initRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(id: String) {
        requireActivity().startActivity(DetailMovieActivity.newIntent(requireActivity(), id.toInt()))
    }

    private fun initRecycler() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)

        with(binding.rvMovie) {
            addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
            setHasFixedSize(true)
            this.adapter = mAdapter
        }
    }

    private fun observeData() {
        viewModel.getTrendingMovie(Constants.VOTE_BEST).observe(viewLifecycleOwner){movies ->
            print(movies.message)
            when (movies.status) {
                Status.LOADING -> showProgressBar(true)
                Status.SUCCESS -> {
                    showProgressBar(false)
                    mAdapter.submitList(movies.data)
                    mAdapter.setOnItemClickCallback(this)
                    mAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    showProgressBar(false)
                    Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        binding.progressBar.isVisible = state
        binding.rvMovie.isInvisible = state
    }
}