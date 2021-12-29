package org.techtown.tmdbclient.data.repository.movie.datasourceImpl

import org.techtown.tmdbclient.data.api.TMDBService
import org.techtown.tmdbclient.data.model.movie.MovieList
import org.techtown.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey: String
) : MovieRemoteDatasource {
  override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


}