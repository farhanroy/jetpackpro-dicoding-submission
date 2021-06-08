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
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.databinding.FragmentTvShowBinding
import github.learn.movie.ui.detail.DetailMovieActivity
import github.learn.movie.ui.detail.DetailTvActivity
import github.learn.movie.ui.home.adapter.TvShowAdapter
import github.learn.movie.ui.home.viewmodel.TvShowViewModel
import github.learn.movie.utils.Constants.VOTE_BEST
import github.learn.movie.utils.MarginItemDecoration
import github.learn.movie.utils.Status

@AndroidEntryPoint
class TvShowFragment : Fragment(), TvShowAdapter.OnItemClickCallback {

    private val viewModel: TvShowViewModel by viewModels()
    private val mAdapter = TvShowAdapter()
    
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        initRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(id: String) {
        requireActivity().startActivity(DetailTvActivity.newIntent(requireActivity(), id.toInt()))
    }

    private fun initRecycler() {
        val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

        with(binding.rvTv) {
            addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = mAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.getTvShow(VOTE_BEST).observe(viewLifecycleOwner) { tvShows ->
            when (tvShows.status) {
                Status.LOADING -> showProgressBar(true)
                Status.SUCCESS -> {
                    showProgressBar(false)
                    mAdapter.submitList(tvShows.data)
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
        binding.rvTv.isInvisible = state
    }

}