package sample.com.contactmanagement.data.manager;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ashwith on 2/11/17.
 */

public class FileManager {
    Context mContext;

    public FileManager (Context context) {
        mContext = context;
    }
    public void readFile() {
        try {
            FileInputStream inputStream = mContext.openFileInput("test.txt");
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

    public void saveFile() {
        String fileName = "test.txt";
        String testString = "This is to test file operations";
        File file = mContext.getFilesDir();
        try {
            FileOutputStream outputStream  = mContext.openFileOutput(fileName, mContext.MODE_PRIVATE);
            outputStream.write(testString.getBytes());
            outputStream.close();
            Log.println(Log.ASSERT, "Log", file.toString());
            Toast.makeText(mContext.getApplicationContext(), "Suuccessfully saved " + file, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(mContext.getApplicationContext(), "failded to saved " + file, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext.getApplicationContext(), "failded to saved after ioexception " + file, Toast.LENGTH_LONG).show();
        }
        {
        }
    }

    public void saveCache() {
        File cashFile = mContext.getCacheDir();
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
        File file = mContext.getCacheDir();
        File inputFile = new File(file, "test.txt");
        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            BufferedInputStream reader = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer input = null;
            while ((line = bufferedReader.readLine())!= null) {
                input = input.append(line);
                Log.println(Log.DEBUG, "tag", input.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveExternal() {
        String content = "hello world";
        File file;
        FileOutputStream outputStream;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "MyCache");

            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
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
