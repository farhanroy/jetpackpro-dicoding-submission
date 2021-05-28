package github.learn.movie.ui.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.DetailEntity
import github.learn.movie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val dummyMovie = DataDummy.getDetailMovie()
    private val dummyMovieId = dummyMovie.id.toString()



    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    // Get Data Movie Testing
    @Before
    fun setUpMovie() {
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyMovie

        `when`(movieCatalogueRepository.getDetailMovie(dummyMovieId)).thenReturn(movie)
        val detailEntity = viewModel.getMovie(dummyMovieId).value as DetailEntity
        verify(movieCatalogueRepository).getDetailMovie(dummyMovieId)

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.backdropPath, detailEntity.backdropPath)
        assertEquals(dummyMovie.genres, detailEntity.genres)
        assertEquals(dummyMovie.id, detailEntity.id)
        assertEquals(dummyMovie.overview, detailEntity.overview)
        assertEquals(dummyMovie.posterPath, detailEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyMovie.runtime, detailEntity.runtime)
        assertEquals(dummyMovie.title, detailEntity.title)
        assertEquals(dummyMovie.voteAverage.toInt(), detailEntity.voteAverage.toInt())

        viewModel.getMovie(dummyMovieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }


}