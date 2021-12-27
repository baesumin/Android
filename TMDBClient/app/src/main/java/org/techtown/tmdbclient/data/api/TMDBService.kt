package org.techtown.tmdbclient.data.api

import androidx.room.Query
import org.techtown.tmdbclient.data.MovieList
import retrofit2.Response

class TMDBService {

  suspend fun getPopularMovies(@Query):Response<MovieList>
}