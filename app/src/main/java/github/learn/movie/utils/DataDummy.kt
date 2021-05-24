    package github.learn.movie.utils

import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.data.source.local.entity.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                0,
                "A Star Is Born",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                4.3
            )
        )
        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
            0,
            "The Arrow",
            "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
            18.3
            ))
        return tvShows
    }
}