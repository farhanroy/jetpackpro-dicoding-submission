package github.learn.movie.ui.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import github.learn.movie.data.MovieCatalogRepository
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.utils.DataDummy
import github.learn.movie.utils.Resource
import junit.framework.Assert.assertNotNull
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogRepository: MovieCatalogRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieCatalogRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(3)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShow

        `when`(movieCatalogRepository.getTvShows("BEST")).thenReturn(tvShows)
        val tvShow = viewModel.getTvShow("BEST").value?.data
        verify(movieCatalogRepository).getTvShows("BEST")
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        viewModel.getTvShow("BEST").observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}