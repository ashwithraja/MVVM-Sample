package sample.com.contactmanagement;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ashwith on 11/8/17.
 */

public class ContactApplication extends Application {
    public static Context applicationcontext  ;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationcontext = getApplicationContext();
    }
}
