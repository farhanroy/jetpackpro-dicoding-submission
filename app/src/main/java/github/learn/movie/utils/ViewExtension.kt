package github.learn.movie.utils

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

fun Intent.putParcel(key: String = "parcel_key", parcel: Parcelable?) {
    val bundle = Bundle()
    bundle.putParcelable(key, parcel)
    this.putExtra(key, bundle)
}

fun <T : Parcelable> Intent.getParcel(key: String = "parcel_key"): T? {
    return this.getBundleExtra(key)?.getParcelable(key)
}