package org.techtown.tmdbclient.domain.repository

import org.techtown.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
  suspend fun getTvShows():List<TvShow>?
  suspend fun updateTvShows():List<TvShow>?
}