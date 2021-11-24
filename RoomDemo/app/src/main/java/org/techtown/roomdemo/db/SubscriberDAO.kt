package org.techtown.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
  @Insert
   fun insertSubscriber(subscriber: Subscriber): Long

  @Update
   fun updateSubscriber(subscriber: Subscriber)

  @Delete
   fun deleteSubscriber(subscriber: Subscriber)

  @Query("DELETE FROM subscriber_data_table")
   fun deleteAll()

  @Query("SELECT * FROM subscriber_data_table")
  fun getAllSubscribers():LiveData<List<Subscriber>>
}