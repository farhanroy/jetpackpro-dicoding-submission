package github.learn.movie.ui.home.viewmodel

import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    
    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val tv = viewModel.getTvShow()
        TestCase.assertNotNull(tv)
        assertEquals(10, tv.size)
    }
}