package github.learn.movie.ui.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.utils.DataDummy
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TrendingMovieViewModelTest {
    private lateinit var viewModel: TrendingMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = TrendingMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.getMovies()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(movieCatalogueRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getTrendingMovie().value
        verify(movieCatalogueRepository).getMovies()
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel.getTrendingMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}