package github.learn.movie.ui.home.viewmodel

import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TrendingMovieViewModelTest {
    private lateinit var viewModel: TrendingMovieViewModel

    @Before
    fun setUp() {
        viewModel = TrendingMovieViewModel()
    }

    @Test
    fun getListMovie() {
        val movie = viewModel.getTrendingMovie()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }
}