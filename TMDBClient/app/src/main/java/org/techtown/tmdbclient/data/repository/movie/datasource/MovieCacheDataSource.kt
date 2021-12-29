package org.techtown.tmdbclient.data.repository.movie.datasource

import org.techtown.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
  suspend fun getMoviesFromCache():List<Movie>
  suspend fun saveMoviesToCache(movies:List<Movie>)
}