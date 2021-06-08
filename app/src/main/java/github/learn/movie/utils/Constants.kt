package github.learn.movie.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object Constants {
    const val DB_NAME = "app.db"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    const val MOVIE_TABLE = "movie_table"
    const val TV_SHOW_TABLE = "tv_show_table"
    const val VOTE_BEST = "Best"
    const val VOTE_WORST = "Worst"
    const val RANDOM = "Random"

    fun getSortedQuery(filter: String, table_name: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $table_name ")
        when (filter) {
            VOTE_BEST -> simpleQuery.append("ORDER BY voteAverage DESC")
            VOTE_WORST -> simpleQuery.append("ORDER BY voteAverage ASC")
            RANDOM -> simpleQuery.append("ORDER BY RANDOM()")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}