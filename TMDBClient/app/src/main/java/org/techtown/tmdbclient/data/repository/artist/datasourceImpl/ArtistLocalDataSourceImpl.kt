package org.techtown.tmdbclient.data.repository.artist.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.tmdbclient.data.db.ArtistDao
import org.techtown.tmdbclient.data.model.artist.Artist
import org.techtown.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
  override suspend fun getArtistsFromDB(): List<Artist> {
    return artistDao.getArtists()
  }

  override suspend fun saveArtistsToDB(movies: List<Artist>) {
    CoroutineScope(Dispatchers.IO).launch {
      artistDao.saveArtists(movies)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope(Dispatchers.IO).launch {
      artistDao.deleteAllArtists()
    }
  }
}