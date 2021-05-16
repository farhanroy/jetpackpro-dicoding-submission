package github.learn.movie.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TV(
    var id: String,
    var title: String,
    var description: String,
    var genre: String,
    var releaseYear: String,
    var imgPoster: Int,
    var imgBackground: Int
): Parcelable