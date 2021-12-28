package org.techtown.tmdbclient.data.api

import org.techtown.tmdbclient.data.model.artist.ArtistList
import org.techtown.tmdbclient.data.model.movie.MovieList
import org.techtown.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class TMDBService {

  @GET("movie/popular")
  suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList> {

  }

  @GET("tv/popular")
  suspend fun getPopularTvshows(@Query("api_key") apiKey: String): Response<TvShowList> {

  }

  @GET("person/popular")
  suspend fun getPopularTvArtists(@Query("api_key") apiKey: String): Response<ArtistList> {

  }

}