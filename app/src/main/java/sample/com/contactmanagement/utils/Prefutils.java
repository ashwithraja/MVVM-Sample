package sample.com.contactmanagement.utils;

import android.content.Context;
import android.content.SharedPreferences;

import sample.com.contactmanagement.ContactApplication;

/**
 * Created by ashwith on 30/10/17.
 */

public class Prefutils {
    private static Prefutils mPrefUtils;
    private SharedPreferences mSharedpreference;

    private Prefutils () {
        mSharedpreference = ContactApplication.applicationcontext.getSharedPreferences("shared_oref", Context.MODE_PRIVATE);
    }

    public static Prefutils getInstance() {
        if (mPrefUtils == null)
            mPrefUtils = new Prefutils();

        return mPrefUtils;
    }

    public void saveString(String name, String values) {
        SharedPreferences.Editor edit =  mSharedpreference.edit();
        edit.putString(name, values);
        edit.commit();
    }

    public String getString(String name) {
       return mSharedpreference.getString(name, null);
    }
}
