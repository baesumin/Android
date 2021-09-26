package org.techtown.contactroom.util;

import android.app.Person;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.techtown.contactroom.data.ContactDao;
import org.techtown.contactroom.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase {

  public abstract ContactDao contactDao();

  public static final int NUMBER_OF_THREADS = 4;

  private static volatile ContactRoomDatabase INSTANCE;
  private static final ExecutorService databaseWriteExecutor
          = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public static ContactRoomDatabase getDatabase(final Context context) {
    if (context == null) {
      synchronized (ContactRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                  ContactRoomDatabase.class, "contact_database")
                  .build();
        }
      }
    }

    return INSTANCE;
  }
}
