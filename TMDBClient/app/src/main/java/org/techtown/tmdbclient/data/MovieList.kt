package org.techtown.tmdbclient.data
import com.google.gson.annotations.SerializedName
import org.techtown.tmdbclient.data.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
)