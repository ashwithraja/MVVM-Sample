package sample.com.contactmanagement.ui;

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

import sample.com.contactmanagement.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        saveFile();
        readFile();
        saveCache();
        getcache();

    }

    private void readFile() {
        try {
            FileInputStream inputStream = openFileInput("test.txt");
            StringBuffer buffer = new StringBuffer();
            while((inputStream.read())!= -1) {
                buffer.append((char) inputStream.read());
            }
            Log.println(Log.ASSERT, "Log", buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
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

    private void saveCache() {
        File cashFile = getCacheDir();
        File file = new File(cashFile.getAbsolutePath(), "test.txt");
        String input = "input";
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(input.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getcache() {
        File file = getCacheDir();
        File inputFile = new File(file, "test.txt");
        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            while (inputStream.read() != -1) {
                Log.println(Log.DEBUG, "tag", String.valueOf(((char)inputStream.read())));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
