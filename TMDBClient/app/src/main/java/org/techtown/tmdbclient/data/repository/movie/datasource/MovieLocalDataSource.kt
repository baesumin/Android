package org.techtown.tmdbclient.data.repository.movie.datasource

import org.techtown.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
  suspend fun getMoviesFromDB():List<Movie>
  suspend fun saveMoviesToDB(movies:List<Movie>)
  suspend fun clearAll()
}