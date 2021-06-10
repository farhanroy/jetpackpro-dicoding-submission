package github.learn.movie.ui.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.DetailEntity
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.utils.DataDummy
import github.learn.movie.utils.Resource
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvViewModelTest {
    private lateinit var viewModel: DetailTvViewModel

    private val dummyTvShow = DataDummy.getDetailTvShow()
    private val dummyTvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogRepository: MovieCatalogRepository

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    // Get Data TV Show Testing
    @Before
    fun setupTvShow() {
        viewModel = DetailTvViewModel(movieCatalogRepository)
    }

    @Test
    fun getTvShowDetail() {
        val dummyDetailTvShow = Resource.success(DataDummy.getDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyDetailTvShow

        `when`(movieCatalogRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)

        viewModel.setTvShow(dummyTvShowId)
        viewModel.getDetailTvShow().observeForever(tvShowObserver)
        verify(movieCatalogRepository).getDetailTvShow(dummyTvShowId)
        verify(tvShowObserver).onChanged(dummyDetailTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyDetailTvShow = Resource.success(DataDummy.getDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyDetailTvShow

        `when`(movieCatalogRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)

        viewModel.setTvShow(dummyTvShowId)
        viewModel.setFavoriteTvShow()
        verify(movieCatalogRepository).setFavoriteTvShow(tvShow.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvShowObserver)
    }
}