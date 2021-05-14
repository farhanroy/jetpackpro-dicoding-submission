package github.learn.movie.ui.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import github.learn.core.data.Resource
import github.learn.core.domain.model.Movie
import github.learn.core.domain.usecase.MovieUseCase
import github.learn.movie.utils.mock
import org.junit.Rule
import org.junit.Test
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.mockito.Mock
import org.mockito.Mockito.verify

class TrendingMovieViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Resource<List<Movie>>>

    private val movieUseCases = mock<MovieUseCase>()

    private val viewModel by lazy { TrendingMovieViewModel(movieUseCases) }

    @Test
    fun getListMovie()  = runBlocking {

        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(Resource.Loading())

    }
}