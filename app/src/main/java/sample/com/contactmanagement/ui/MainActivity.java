package sample.com.contactmanagement.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import sample.com.contactmanagement.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String fileName = "test.txt";
        String testString = "This is to test file operations";
        File file = getFilesDir();
        try {
            FileOutputStream outputStream  = openFileOutput(fileName, MODE_PRIVATE);
            outputStream.write(testString.getBytes());
            outputStream.close();
            Log.println(Log.ASSERT, "Log", file.toString());
            Toast.makeText(getApplicationContext(), "Suuccessfully saved " + file, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "failded to saved " + file, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "failded to saved after ioexception " + file, Toast.LENGTH_LONG).show();
        }
        {
        }
    }

}
