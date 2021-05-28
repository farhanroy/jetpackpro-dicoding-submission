package github.learn.movie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import github.learn.movie.R
import github.learn.movie.utils.DataDummy
import github.learn.movie.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTvShow = DataDummy.getDetailTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail)).check(matches(withTagValue(equalTo(dummyDetailMovie.posterPath))))
        onView(withId(R.id.coordinator_layout)).perform(swipeUp())
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(withTagValue(equalTo(dummyDetailMovie.backdropPath))))
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.collapsing)).check(matches(withContentDescription(dummyDetailMovie.title)))
        onView(withId(R.id.tv_detail_genre_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyDetailMovie.overview)))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail)).check(matches(withTagValue(equalTo(dummyDetailTvShow.posterPath))))
        onView(withId(R.id.coordinator_layout)).perform(swipeUp())
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(withTagValue(equalTo(dummyDetailTvShow.backdropPath))))
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.collapsing)).check(matches(withContentDescription(dummyDetailTvShow.title)))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
    }
}