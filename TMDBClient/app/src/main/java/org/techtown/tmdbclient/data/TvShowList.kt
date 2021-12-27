package org.techtown.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class TvShowList(

  @SerializedName("results")
    val tvShows: List<TvShow>
)