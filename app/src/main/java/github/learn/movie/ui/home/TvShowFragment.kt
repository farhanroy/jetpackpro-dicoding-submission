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
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.databinding.FragmentTvShowBinding
import github.learn.movie.ui.detail.DetailTvActivity
import github.learn.movie.ui.home.adapter.TvShowAdapter
import github.learn.movie.ui.home.viewmodel.TvShowViewModel
import github.learn.movie.utils.GridSpacingItemDecoration

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var adapter: TvShowAdapter
    
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
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
        viewModel.getTvShow().observe(viewLifecycleOwner) { tv ->
            initRecycler(tv)
        }
    }


    private fun initRecycler(tv: List<TvShowEntity>) {
        adapter = TvShowAdapter {
            requireActivity().startActivity(DetailTvActivity.newIntent(requireActivity(), it))
        }
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)
        binding.rvTv.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
        binding.rvTv.adapter = adapter
        adapter.submitData(tv)
    }
}