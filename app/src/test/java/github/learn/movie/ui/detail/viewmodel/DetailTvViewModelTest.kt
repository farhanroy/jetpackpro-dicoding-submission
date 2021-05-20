package github.learn.movie.ui.detail.viewmodel

import github.learn.movie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailTvViewModelTest {

    private lateinit var viewModel: DetailTvViewModel

    private val dummyTv= DataDummy.generateDummyTvShows()[0]

    @Before
    fun setUp() {
        viewModel = DetailTvViewModel()
        viewModel.setTv(dummyTv)
    }

    @Test
    fun getTv() {
        val tv = viewModel.getTv()
        assertNotNull(tv)
        assertEquals(dummyTv.title, tv.title)
        assertEquals(dummyTv.description, tv.description)
        assertEquals(dummyTv.genre, tv.genre)
        assertEquals(dummyTv.imgPoster, tv.imgPoster)
        assertEquals(dummyTv.imgBackground, tv.imgBackground)
    }
}