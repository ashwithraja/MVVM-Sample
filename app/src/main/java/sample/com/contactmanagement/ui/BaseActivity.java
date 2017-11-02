package sample.com.contactmanagement.ui;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import sample.com.contactmanagement.R;
import sample.com.contactmanagement.data.local.database.DatabaseHandler;
import sample.com.contactmanagement.data.manager.FileManager;
import sample.com.contactmanagement.data.model.Contact;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initialiseFileoperations();
        initialisedatabase();

    }

    private void initialiseFileoperations() {
        FileManager fileManager = new FileManager(this);
        fileManager.saveFile();
        fileManager.readFile();
        fileManager.saveCache();
        fileManager.getcache();
    }

    private void initialisedatabase() {
        DatabaseHandler handler = new DatabaseHandler(this);
        handler.addContact(new Contact("ashwith", "7411894533"));
        handler.addContact(new Contact("ashwith1", "7411894533"));
        handler.addContact(new Contact("ashwith2", "7411894533"));

        displayContacts(handler);

        Contact contact = handler.getContact(4);
        Log.println(Log.DEBUG, TAG, contact.getName() + " : " + contact.getPhoneNumber());
    }

    private void displayContacts(DatabaseHandler handler) {
        List<Contact> contactList = handler.getAllContacts();
        for (Contact contact : contactList) {
            Log.println(Log.DEBUG, TAG, contact.getName() + " : " + contact.getPhoneNumber());
        }
    }
}
