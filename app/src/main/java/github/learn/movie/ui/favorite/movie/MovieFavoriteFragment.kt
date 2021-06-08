package github.learn.movie.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import github.learn.movie.R
import github.learn.movie.databinding.FragmentMovieFavoriteBinding
import github.learn.movie.ui.detail.DetailMovieActivity

@AndroidEntryPoint
class MovieFavoriteFragment : Fragment(), MovieFavoriteAdapter.OnItemClickCallback {

    private var _fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = _fragmentMovieFavoriteBinding

    private val viewModel: MovieFavoriteViewModel by viewModels()
    private lateinit var mAdapter: MovieFavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavMovies().observe(viewLifecycleOwner) { favMovies ->
            mAdapter.submitList(favMovies)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(binding?.rvFavMovie)

        if (activity != null) {
            mAdapter = MovieFavoriteAdapter()
            mAdapter.setOnItemClickCallback(this)

            viewModel.getFavMovies().observe(viewLifecycleOwner) { favMovies ->
                mAdapter.submitList(favMovies)
            }

            initRecycler()
        }
    }

    private fun initRecycler() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_content_very_small)

        with(binding!!.rvFavMovie) {
            addItemDecoration(
                github.learn.movie.utils.GridSpacingItemDecoration(
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

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = mAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setFavMovie(it) }

                val snackBar = Snackbar.make(requireView(), R.string.undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.ok) { _ ->
                    movieEntity?.let { viewModel.setFavMovie(it) }
                }
                snackBar.show()
            }
        }
    })

    override fun onDestroy() {
        super.onDestroy()
        _fragmentMovieFavoriteBinding = null
    }

    override fun onItemClicked(id: String) {
        requireActivity().startActivity(DetailMovieActivity.newIntent(requireActivity(), id.toInt()))
    }
}