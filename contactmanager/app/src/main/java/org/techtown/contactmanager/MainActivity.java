package org.techtown.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.techtown.contactmanager.data.DatabaseHandler;
import org.techtown.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DatabaseHandler db = new DatabaseHandler(MainActivity.this);

    Log.d("Count", "onCreate: " + db.getCount());

    // create contact object first
    Contact jeremy = new Contact();
    jeremy.setName("Jeremy");
    jeremy.setPhoneNumber("987654321");

    Contact j = new Contact();
    j.setName("jason");
    j.setPhoneNumber("1234");

    db.addContact(jeremy);

//    Contact c = db.getContact(1);
//    c.setName("NewJeremy");
//    c.setPhoneNumber("2323");
//
//    int updateRow = db.updateContact(c);

    List<Contact> contactList = db.getAllContacts();

    for (Contact contact : contactList) {
      Log.d("MainActivity", "onCreate: " + contact.getName());
    }
  }
}