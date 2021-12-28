package org.techtown.tmdbclient.domain.repository

import org.techtown.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
  suspend fun getArtists():List<Artist>?
  suspend fun updateArtists():List<Artist>?
}