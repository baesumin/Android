package org.techtown.contactmanager.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.techtown.contactmanager.R;
import org.techtown.contactmanager.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

  public DatabaseHandler(Context context) {
    super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    //SQL
    /*
      create table _name(id, name, phone_number);
     */
    String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
            + Util.KEY_ID + " INTEAGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
            + Util.KEY_PHONE_NUMBER + " TEXT" + ")";
    db.execSQL(CREATE_CONTACT_TABLE); // creating our table
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String DROP_TABLE = String.valueOf(R.string.db_drop);
    db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

    // Create a table again
    onCreate(db);
  }
}
