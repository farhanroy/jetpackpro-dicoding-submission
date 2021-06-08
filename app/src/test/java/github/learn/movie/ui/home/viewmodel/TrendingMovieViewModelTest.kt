package github.learn.movie.ui.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.utils.DataDummy
import github.learn.movie.utils.Resource
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
    private lateinit var movieCatalogRepository: MovieCatalogRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = TrendingMovieViewModel(movieCatalogRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(3)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(movieCatalogRepository.getMovies("BEST")).thenReturn(movies)
        val movie = viewModel.getTrendingMovie("BEST").value?.data
        verify(movieCatalogRepository).getMovies("BEST")
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel.getTrendingMovie("BEST").observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}