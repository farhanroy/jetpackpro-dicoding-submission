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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvViewModelTest {

    private lateinit var viewModel: DetailTvViewModel

    private val dummyTvShow = DataDummy.getDetailTvShow()
    private val dummyTvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    // Get Data TV Show Testing
    @Before
    fun setupTvShow() {
        viewModel = DetailTvViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(movieCatalogueRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)
        val detailEntity = viewModel.getTv(dummyTvShowId).value as DetailEntity
        Mockito.verify(movieCatalogueRepository).getDetailTvShow(dummyTvShowId)

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.backdropPath, detailEntity.backdropPath)
        assertEquals(dummyTvShow.genres, detailEntity.genres)
        assertEquals(dummyTvShow.id, detailEntity.id)
        assertEquals(dummyTvShow.overview, detailEntity.overview)
        assertEquals(dummyTvShow.posterPath, detailEntity.posterPath)
        assertEquals(dummyTvShow.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyTvShow.runtime, detailEntity.runtime)
        assertEquals(dummyTvShow.title, detailEntity.title)
        assertEquals(dummyTvShow.voteAverage.toInt(), detailEntity.voteAverage.toInt())

        viewModel.getTv(dummyTvShowId).observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyTvShow)
    }
}