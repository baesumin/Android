package org.techtown.tmdbclient.data.repository.artist.datasource

import org.techtown.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
  suspend fun getArtists(): Response<ArtistList>
}