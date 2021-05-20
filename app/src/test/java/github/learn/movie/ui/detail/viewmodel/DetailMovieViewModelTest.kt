package github.learn.movie.ui.detail.viewmodel

import github.learn.movie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setMovie(dummyMovie)
    }

    @Test
    fun getMovie() {
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
        assertEquals(dummyMovie.imgBackground, movie.imgBackground)
    }
}