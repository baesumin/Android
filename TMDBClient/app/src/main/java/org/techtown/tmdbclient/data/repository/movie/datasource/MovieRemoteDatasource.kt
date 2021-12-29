package org.techtown.tmdbclient.data.repository.movie.datasource

import org.techtown.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
  suspend fun getMovies(): Response<MovieList>
}