package github.learn.movie.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.databinding.FragmentTvShowFavoriteBinding
import github.learn.movie.ui.detail.DetailMovieActivity
import github.learn.movie.ui.detail.DetailTvActivity
import github.learn.movie.utils.GridSpacingItemDecoration

@AndroidEntryPoint
class TvShowFavoriteFragment : Fragment(), TvShowFavoriteAdapter.OnItemClickCallback {

    private val viewModel: TvShowFavoriteViewModel by viewModels()
    private var _fragmentTvShowBinding: FragmentTvShowFavoriteBinding? = null
    private val binding get() = _fragmentTvShowBinding

    private lateinit var mAdapter: TvShowFavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentTvShowBinding =
            FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavTvShows().observe(viewLifecycleOwner) { favTvShow ->
            mAdapter.submitList(favTvShow)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(binding?.rvFavTvShow)

        if (activity != null) {

            mAdapter = TvShowFavoriteAdapter()
            mAdapter.setOnItemClickCallback(this)

            viewModel.getFavTvShows().observe(viewLifecycleOwner) { favTvShow ->
                mAdapter.submitList(favTvShow)
            }

            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)

            with(binding!!.rvFavTvShow) {
                addItemDecoration(
                    GridSpacingItemDecoration(
                        2,
                        spacingInPixels,
                        true,
                        0
                    )
                )
                setHasFixedSize(true)
                this.adapter = mAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = mAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModel.setFavTvShow(it) }

                val snackBar = Snackbar.make(requireView(), R.string.undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.ok) { _ ->
                    tvShowEntity?.let { viewModel.setFavTvShow(it) }
                }
                snackBar.show()
            }
        }
    })

    override fun onItemClicked(id: String) {
        requireActivity().startActivity(DetailTvActivity.newIntent(requireActivity(), id.toInt()))
    }
}