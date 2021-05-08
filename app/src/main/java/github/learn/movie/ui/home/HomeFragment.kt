package github.learn.movie.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import github.learn.core.data.Resource
import github.learn.movie.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movie.observe(viewLifecycleOwner) { movie ->
            when (movie) {
                is Resource.Loading -> Log.d("MOVIE", "LOADING.......")
                is Resource.Success -> {
                    Log.d("MOVIE", "SUCCESS, Data size = ${movie.data?.size}")
                }
                is Resource.Error -> {
                    Log.d("MOVIE", "ERR: ${movie.message}")
                }
            }
        }
    }
}