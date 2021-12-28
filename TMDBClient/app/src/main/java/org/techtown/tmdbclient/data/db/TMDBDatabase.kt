package org.techtown.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.techtown.tmdbclient.data.db.ArtistDao
import org.techtown.tmdbclient.data.db.MovieDao
import org.techtown.tmdbclient.data.db.TvShowDao
import org.techtown.tmdbclient.data.model.artist.Artist
import org.techtown.tmdbclient.data.model.movie.Movie
import org.techtown.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
  abstract fun movieDao(): MovieDao
  abstract fun tvDao(): TvShowDao
  abstract fun artistDao(): ArtistDao
}