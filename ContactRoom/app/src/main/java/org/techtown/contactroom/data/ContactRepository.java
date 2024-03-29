package org.techtown.contactroom.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.techtown.contactroom.model.Contact;
import org.techtown.contactroom.util.ContactRoomDatabase;

import java.util.List;

public class ContactRepository {
  private ContactDao contactDao;
  private LiveData<List<Contact>> allContacts;

  public ContactRepository(Application application) {
    ContactRoomDatabase db = ContactRoomDatabase.getDatabase(application);
    contactDao = db.contactDao();

    allContacts = contactDao.getAllContacts();


  }
  public LiveData<List<Contact>> getAllData() {return allContacts;}
  public void insert(Contact contact){
    ContactRoomDatabase.databaseWriteExecutor.execute(()-> {
      contactDao.insert(contact);
    })
  }
}
