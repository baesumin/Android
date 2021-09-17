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

    // create contact object first
    Contact jeremy = new Contact();
    jeremy.setName("Jeremy");
    jeremy.setPhoneNumber("987654321");

    //db.addContact(jeremy);

    List<Contact> contactList = db.getAllContacts();

    for(Contact contact: contactList){
      Log.d("MainActivity", "onCreate: " + contact.getName());
    }
  }
}